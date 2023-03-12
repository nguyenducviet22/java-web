package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Author;
import model.Genre;
import model.Product;

public class Product_Inter_DAO implements Interface_DAO<Product> {

	@Override
	public ArrayList<Product> selectAll() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from product";
			PreparedStatement pst = con.prepareStatement(sql);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String productCode = rs.getString("product_code");
				String nameOfProduct = rs.getString("name_of_product");
				String authorCode = rs.getString("author_code");
				int publishedYear = rs.getInt("published_year");
				double importPrice = rs.getDouble("import_price");
				double sellingPrice = rs.getDouble("selling_price");
				double basisPrice = rs.getDouble("basis_price");
				int quantity = rs.getInt("quantity");
				String genreCode = rs.getString("genre_code");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = new Author_Inter_DAO().selectById(new Author(authorCode, "", null, ""));
				Genre genre = new Genre_Inter_DAO().selectById(new Genre(genreCode, ""));

				Product product = new Product(productCode, nameOfProduct, author, publishedYear, importPrice,
						sellingPrice, basisPrice, quantity, genre, language, description);
				result.add(product);
			}

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Product selectById(Product t) {
		Product result = null;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from product where product_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getProductCode());

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String productCode = rs.getString("product_code");
				String nameOfProduct = rs.getString("name_of_product");
				String authorCode = rs.getString("author_code");
				int publishedYear = rs.getInt("published_year");
				double importPrice = rs.getDouble("import_price");
				double sellingPrice = rs.getDouble("selling_price");
				double basisPrice = rs.getDouble("basis_price");
				int quantity = rs.getInt("quantity");
				String genreCode = rs.getString("genre_code");
				String language = rs.getString("language");
				String description = rs.getString("description");

				Author author = new Author_Inter_DAO().selectById(new Author(authorCode, "", null, ""));
				Genre genre = new Genre_Inter_DAO().selectById(new Genre(genreCode, ""));

				result = new Product(productCode, nameOfProduct, author, publishedYear, importPrice, sellingPrice,
						basisPrice, quantity, genre, language, description);

			}

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insert(Product t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "insert into product (product_code, name_of_product, author_code, published_year, import_price, selling_price, basis_price, quantity, genre_code, language, description)"
					+ "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getProductCode());
			pst.setString(2, t.getNameOfProduct());
			pst.setString(3, t.getAuthor().getAuthorCode());
			pst.setInt(4, t.getPublishedYear());
			pst.setDouble(5, t.getImportPrice());
			pst.setDouble(6, t.getSellingPrice());
			pst.setDouble(7, t.getBasisPrice());
			pst.setInt(8, t.getQuantity());
			pst.setString(9, t.getGenre().getGenreCode());
			pst.setString(10, t.getLanguage());
			pst.setString(11, t.getDescription());

			// #3 conduct SQL command
			System.out.println(sql);
			result = pst.executeUpdate();

			// #4
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product product : arr) {
			count += this.insert(product);
		}
		return count;
	}

	@Override
	public int delete(Product t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "delete from product where product_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getProductCode());

			// #3 conduct SQL command
			System.out.println(sql);
			result = pst.executeUpdate();

			// #4
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteAll(ArrayList<Product> arr) {
		int count = 0;
		for (Product product : arr) {
			count += this.delete(product);
		}
		return count;
	}

	@Override
	public int update(Product t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update product " + " set " + " name_of_product = ?" + ", author_code = ?"
					+ ", published_year = ?" + ", import_price = ?" + ", selling_price = ?" + ", basis_price = ?"
					+ ", quantity = ?" + ", genre_code = ?" + ", language = ?" + ", description = ?"
					+ " where product_code = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getProductCode());
			pst.setString(2, t.getNameOfProduct());
			pst.setString(3, t.getAuthor().getAuthorCode());
			pst.setInt(4, t.getPublishedYear());
			pst.setDouble(5, t.getImportPrice());
			pst.setDouble(6, t.getSellingPrice());
			pst.setDouble(7, t.getBasisPrice());
			pst.setInt(8, t.getQuantity());
			pst.setString(9, t.getGenre().getGenreCode());
			pst.setString(10, t.getLanguage());
			pst.setString(11, t.getDescription());

			// #3 conduct SQL command
			System.out.println(sql);
			result = pst.executeUpdate();

			// #4
			System.out.println("sql was conducted:" + sql);
			System.out.println(result + " line(s) changed");

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

}
