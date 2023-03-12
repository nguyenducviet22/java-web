package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Customer_Inter_DAO;
import model.Customer;

/**
 * Servlet implementation class changeInfo
 */
@WebServlet("/change-info")
public class changeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public changeInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
				Customer oldCustomer = new Customer(customerCode, "", "", fullName, gender, address, receivedAddress,
						Date.valueOf(dateOfBirth), phoneNumber, email);
				cusDao.updateInfo(oldCustomer);
				Customer updateCustomer = cusDao.selectById(oldCustomer);
				request.getSession().setAttribute("customer", updateCustomer);
				url = "/html.jsp";
			}
		}
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
