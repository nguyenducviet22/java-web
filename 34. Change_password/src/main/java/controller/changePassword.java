package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioFormat.Encoding;

import database.Customer_Inter_DAO;
import model.Customer;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/change-password")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public changePassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
					if (cusDao.changepassword(customer)) {
						error = "You have changed your password";
					url = "/html.jsp";
					} else {
						error = "You have not changed your password";
					}
				}
			}
		}
		request.setAttribute("error", error);
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
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

}
