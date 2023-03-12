package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Customer_Inter_DAO;
import model.Customer;
import util.Encoding;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/sign-in")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		String url ="";
		if (customer != null) {
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			url = "/html.jsp";
		} else {
			request.setAttribute("error", "The username or password you entered is incorrect!");
			url = "/signIn.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
