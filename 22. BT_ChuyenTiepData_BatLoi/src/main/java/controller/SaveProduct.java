package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveProduct
 */
@WebServlet("/save-product")
public class SaveProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SaveProduct() {
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

		String productCode = request.getParameter("productCode");
		String nameOfProduct = request.getParameter("nameOfProduct");
		String inputPrice_String = request.getParameter("inputPrice");
		String sellingPrice_String = request.getParameter("sellingPrice");
		String dateTime_String = request.getParameter("dateTime");
		String vat_String = request.getParameter("vat");
		String description = request.getParameter("description");

		// check condition of productCode
		String e_productCode = "";
		if (productCode == null || productCode.trim().length() == 0) {
			e_productCode = "Please, enter product code";
		} else if (productCode.equals("123")) {
			e_productCode = "Product code has existed, check product code again";
		}
		request.setAttribute("e_productCode", e_productCode);

		// (1)keeping values have been entered into boxes
		request.setAttribute("value_productCode", productCode);
		request.setAttribute("value_nameOfProduct", nameOfProduct);
		request.setAttribute("value_inputPrice", inputPrice_String);
		request.setAttribute("value_sellingPrice", sellingPrice_String);
		request.setAttribute("value_dateTime", dateTime_String);
		request.setAttribute("value_vat", vat_String);
		request.setAttribute("value_description", description);
		// url
		String url = "/success.jsp";
		if (e_productCode.length() > 0) {
			url = "/product.jsp";
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
