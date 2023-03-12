package dao;//= package database//Author_Inter_DAO.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import context.DBcontext;
import entity.Product;

public class Dao {
	public ArrayList<Product> selectTop3() {
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			// #1 create connection with CSDL
			Connection con = DBcontext.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from product\r\n" + "order by id desc limit 3";
			PreparedStatement pst = con.prepareStatement(sql);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				double price = rs.getDouble("price");
				String title = rs.getString("title");
				String description = rs.getString("description");

				Product product = new Product(id, name, image, price, title, description);
				list.add(product);
			}

			// #5 stop connection with CSDL
			DBcontext.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		Dao dao = new Dao();
		ArrayList<Product> list = dao.selectTop3();
		for (Product product : list) {
			System.out.println(product);
		}
	}
}
