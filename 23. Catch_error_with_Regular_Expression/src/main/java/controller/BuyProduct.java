package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyProduct
 */
@WebServlet("/buy-product")
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BuyProduct() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String quantity = request.getParameter("quantity");
		String phoneNumbers = request.getParameter("phoneNumbers");
		String email = request.getParameter("email");

		boolean checkError = false;
		double value_quantity = 0;
		// catch error quantity
		try {
			value_quantity = Double.parseDouble(quantity);
		} catch (Exception e) {
			checkError = true;
			request.setAttribute("e_quantity", "No no no, please re-enter quantity");
		}
		// catch error quantity >0
		if (value_quantity == 0) {
			checkError = true;
			request.setAttribute("e_quantity", "No no no, please grater than 0");
		}
		// catch error phone numbers
		Pattern phoneNumbersPattern = Pattern.compile("\\d{10}");
		Matcher phoneNumbersMatcher = phoneNumbersPattern.matcher(phoneNumbers);
		if (!phoneNumbersMatcher.matches()) {
			checkError = true;
			request.setAttribute("e_phoneNumbers", "No no no, please just 10 numbers");
		}
		// catch error email
		Pattern emailPattern = Pattern.compile("\\w+@\\w+(\\.\\w+)+(\\.\\w+)*");
		Matcher emailMatcher = emailPattern.matcher(email);
		if (!emailMatcher.matches()) {
			checkError = true;
			request.setAttribute("e_email", "No no no, please re-enter the right email structure");
		}
		
		String url = "/success.jsp";
		if (checkError) {
			url = "/index.jsp";
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
