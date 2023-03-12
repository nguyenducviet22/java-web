package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.Customer_Inter_DAO;
import model.Customer;

/**
 * Servlet implementation class CusChangeAvatar
 */
@WebServlet("/cus-change-avatar")
public class CusChangeAvatar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CusChangeAvatar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		Object obj = request.getSession().getAttribute("customer");
		Customer customer = null;
		if (obj != null)
			customer = (Customer) obj;
		if (customer != null) {
			try {
				String folder = getServletContext().getRealPath("avatar");
				System.out.println(folder);
				File file;
				int maxFileSize = 5000 * 1024;
				int maxMemSize = 5000 * 1024;

				String contentType = request.getContentType();

				if (contentType.indexOf(contentType) >= 0) {
					DiskFileItemFactory factory = new DiskFileItemFactory();
					// max memory for 1 file
					factory.setSizeThreshold(maxMemSize);

					// create file upload
					ServletFileUpload upload = new ServletFileUpload(factory);
					upload.setSizeMax(maxFileSize);

					List<FileItem> files = upload.parseRequest(request);
					for (FileItem fileItem : files) {
						if (!fileItem.isFormField()) {
							String fileName = System.currentTimeMillis() + fileItem.getName();
							String path = folder + "\\" + fileName;

							file = new File(path);
							fileItem.write(file);

							customer.setLinkAvatar(fileName);

							Customer_Inter_DAO cusDao = new Customer_Inter_DAO();
							cusDao.updateAvatar(customer);
							customer = cusDao.selectById(customer);
						} else {
							String name = fileItem.getFieldName();
							String value = fileItem.getString();
							System.out.println(name + ":" + value);
							
							url = "/html.jsp";
						}
					}
					
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
