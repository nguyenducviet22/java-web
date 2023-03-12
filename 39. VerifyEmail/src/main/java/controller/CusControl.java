package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Customer_Inter_DAO;
import model.Customer;
import util.Email;
import util.Encoding;
import util.VerifiedCode;

/**
 * Servlet implementation class CusControl
 */
@WebServlet("/cus-control")
public class CusControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CusControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String act = request.getParameter("act");
		switch (act) {
		case "sign-in":
			signIn(request, response);
			break;
		case "sign-out":
			signOut(request, response);
			break;
		case "register":
			register(request, response);
			break;
		case "change-password":
			changePassword(request, response);
			break;
		case "change-info":
			changeInfo(request, response);
			break;
		case "verifying":
			verifyCode(request, response);
			break;

		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void signIn(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			password = Encoding.encodeSHA1(password);

			request.setAttribute("username", username);
			request.setAttribute("password", password);

			Customer cus = new Customer();
			cus.setUsername(username);
			cus.setPassword(password);

			Customer_Inter_DAO cusDao = new Customer_Inter_DAO();
			Customer customer = cusDao.selectByUsernameAndPassword(cus);
			String url = "";
			if (customer != null&&customer.isVerifyState()) {
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				url = "/html.jsp";
			} else {
				request.setAttribute("error", "The username or password you entered is incorrect or you have not verify your account!");
				url = "/signIn.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void signOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			session.invalidate();// stop connecting with website
			response.sendRedirect("html.jsp");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String reenteredPassword = request.getParameter("reenteredPassword");
			String fullName = request.getParameter("fullName");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String receivedAddress = request.getParameter("receivedAddress");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");

			request.setAttribute("username", username);
			request.setAttribute("fullName", fullName);
			request.setAttribute("gender", gender);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("address", address);
			request.setAttribute("receivedAddress", receivedAddress);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);

			String url = "";
			String error = "";
			Customer_Inter_DAO cusDao = new Customer_Inter_DAO();
			// check username
			if (cusDao.checkUsername(username)) {
				error += "The username was in existence.<br/>";
			}
			// check password and reenteredPassword
			if (!password.equals(reenteredPassword)) {
				error += "The passwords you entered do not match.<br/>";
			} else {
				password = util.Encoding.encodeSHA1(password);
			}
			request.setAttribute("error", error);
			// other errors
			if (error.length() > 0) {
				url = "/register.jsp";
			} else {
				String customerCode = "23" + System.currentTimeMillis();
				Customer newCustomer = new Customer(customerCode, username, password, fullName, gender, address,
						receivedAddress, Date.valueOf(dateOfBirth), phoneNumber, email);
				if (cusDao.insert(newCustomer) > 0) {
					// VerifiedCode
					String verifiedCode = VerifiedCode.getVerifiedCode();

					// validPeriod
					Date currentTime = new Date(new java.util.Date().getTime());
					Calendar cal = Calendar.getInstance();
					cal.setTime(currentTime);
					cal.add(Calendar.MINUTE, 3);
					Date validPeriod = new Date(cal.getTimeInMillis());

					// VerifiedEmail
					boolean verifiedState = false;

					newCustomer.setVerifyCode(verifiedCode);
					newCustomer.setValidPeriod(validPeriod);
					newCustomer.setVerifyState(verifiedState);

					if (cusDao.updateVerifyEmail(newCustomer) > 0) {
						// send email to cus
						Email.sendEmail(newCustomer.getEmail(), "verify your account", getContent(newCustomer));
					}
				}
				url = "/html.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void changePassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String newRepassword = request.getParameter("newRepassword");

			String oldPasswordSha1 = util.Encoding.encodeSHA1(oldPassword);

			String error = "";
			String url = "";

			// check old and new password
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("customer");
			Customer customer = null;
			if (obj != null)
				customer = (Customer) obj;
			if (customer == null) {
				error = "You need to sign in the system first.";
				url = "/signIn.jsp";
			} else {
				// When cus successfully signed in
				if (!oldPasswordSha1.equals(customer.getPassword())) {
					error = "Your old password is inaccurate";
					url = "/changePassword.jsp";
				} else {
					if (!newPassword.equals(newRepassword)) {
						error = "The new password and new re-passowrd you entered do not match.";
						url = "/changePassword.jsp";
					} else {
						String newPasswordSha1 = util.Encoding.encodeSHA1(newPassword);
						customer.setPassword(newPasswordSha1);
						Customer_Inter_DAO cusDao = new Customer_Inter_DAO();
						if (cusDao.changePassword(customer)) {
							error = "You have changed your password";
							url = "/html.jsp";
						}
					}
				}
			}
			request.setAttribute("error", error);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void changeInfo(HttpServletRequest request, HttpServletResponse response) {
		try {
			String fullName = request.getParameter("fullName");
			String gender = request.getParameter("gender");
			String dateOfBirth = request.getParameter("dateOfBirth");
			String address = request.getParameter("address");
			String receivedAddress = request.getParameter("receivedAddress");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");

			request.setAttribute("fullName", fullName);
			request.setAttribute("gender", gender);
			request.setAttribute("dateOfBirth", dateOfBirth);
			request.setAttribute("address", address);
			request.setAttribute("receivedAddress", receivedAddress);
			request.setAttribute("phoneNumber", phoneNumber);
			request.setAttribute("email", email);

			String url = "";
			String error = "";
			Customer_Inter_DAO cusDao = new Customer_Inter_DAO();
			request.setAttribute("error", error);
			// other errors
			if (error.length() > 0) {
				url = "/register.jsp";
			} else {
				Object obj = request.getSession().getAttribute("customer");
				Customer customer = null;
				if (obj != null)
					customer = (Customer) obj;
				if (customer != null) {
					String customerCode = customer.getCustomerCode();
					Customer oldCustomer = new Customer(customerCode, "", "", fullName, gender, address,
							receivedAddress, Date.valueOf(dateOfBirth), phoneNumber, email);
					cusDao.updateInfo(oldCustomer);
					Customer updateCustomer = cusDao.selectById(oldCustomer);
					request.getSession().setAttribute("customer", updateCustomer);
					url = "/html.jsp";
				}
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void verifyCode(HttpServletRequest request, HttpServletResponse response) {
		try {
			String customerCode = request.getParameter("customerCode");
			String verifyCode = request.getParameter("verifyCode");

			String url = "";
			String msg = "";
			Customer_Inter_DAO cusDao = new Customer_Inter_DAO();

			Customer cus = new Customer();
			cus.setCustomerCode(customerCode);
			Customer customer = cusDao.selectById(cus);

			if (customer != null) {
				if (customer.getVerifyCode().equals(verifyCode)) {
					customer.setVerifyState(true);
					cusDao.updateVerifyEmail(customer);
					msg = "successful verifying";
				} else {
					msg = "failed verifying";
				}
			} else {
				msg = "This account is not in existence";
			}
			url = "/announce.jsp";
			request.setAttribute("error", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (

		Exception e) {
			// TODO: handle exception
		}
	}

	public static String getContent(Customer cus) {
		String link = "http://localhost:8080/26._BookStore/cus-control?act=verifying&customerCode=" + cus.getCustomerCode()
				+ "&verifyCode=" + cus.getVerifyCode() + "";
		String content = "<p>Hello, <strong>" + cus.getFullName() + "</strong></p>\r\n"
				+ "<p>You must verify your account by entering the code <strong>" + cus.getVerifyCode()
				+ "</strong> or clicking the link below.</p>\r\n" + "<p><a href=" + link + ">" + link + "</a></p>\r\n"
				+ "<p>It is an automatic email. Don't reply this. Thank you.</p>";
		return content;
	}

}
