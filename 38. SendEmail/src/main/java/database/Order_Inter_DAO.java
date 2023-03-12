package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Customer;
import model.DetailedOrder;
import model.Order;

public class Order_Inter_DAO implements Interface_DAO<Order> {

	@Override
	public ArrayList<Order> selectAll() {
		ArrayList<Order> result = new ArrayList<Order>();
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from order";
			PreparedStatement pst = con.prepareStatement(sql);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String orderCode = rs.getString("order_code");
				String customerCode = rs.getString("customer_code");
				String receivedAddress = rs.getString("received_address");
				String state = rs.getString("state");
				String formOfPayment = rs.getString("form_of_payment");
				Double paidMoney = rs.getDouble("pay_money");
				Double unpaidMoney = rs.getDouble("unpaid_money");
				Date orderedDay = rs.getDate("ordered_date");
				Date orddeliveredDayeredDay = rs.getDate("delivered_date");

				Customer customer = new Customer_Inter_DAO()
						.selectById(new Customer(customerCode, "", "", "", "", "", "", null, "", ""));

				Order order = new Order(orderCode, customer, receivedAddress, state, formOfPayment, paidMoney,
						unpaidMoney, orderedDay, orddeliveredDayeredDay);
				result.add(order);
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
	public Order selectById(Order t) {
		Order result = null;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from order where order_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getOrderCode());

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String orderCode = rs.getString("order_code");
				String customerCode = rs.getString("customer_code");
				String receivedAddress = rs.getString("received_address");
				String state = rs.getString("state");
				String formOfPayment = rs.getString("form_of_payment");
				Double paidMoney = rs.getDouble("pay_money");
				Double unpaidMoney = rs.getDouble("unpaid_money");
				Date orderedDay = rs.getDate("ordered_date");
				Date orddeliveredDayeredDay = rs.getDate("delivered_date");

				result = new Order(orderCode, null, receivedAddress, state, formOfPayment, paidMoney, unpaidMoney,
						orderedDay, orddeliveredDayeredDay);

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
	public int insert(Order t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "insert into order (order_code, customer_code, received_address, state, form_of_payment, paid_money, unpaid_money, ordered_date, delivered_date)"
					+ "value (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getOrderCode());
			pst.setString(2, t.getCustomer().getCustomerCode());
			pst.setString(3, t.getReceivedAddress());
			pst.setString(4, t.getState());
			pst.setString(5, t.getFormOfPayment());
			pst.setDouble(6, t.getPaidMoney());
			pst.setDouble(7, t.getUnpaidMoney());
			pst.setDate(8, t.getOrderedDay());
			pst.setDate(9, t.getDeliveredDay());

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
	public int insertAll(ArrayList<Order> arr) {
		int count = 0;
		for (Order order : arr) {
			count += this.insert(order);
		}
		return count;
	}

	@Override
	public int delete(Order t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "delete from order where order_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getOrderCode());

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
	public int deleteAll(ArrayList<Order> arr) {
		int count = 0;
		for (Order order : arr) {
			count += this.delete(order);
		}
		return count;
	}

	@Override
	public int update(Order t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update order " 
				+ " set " 
				+ " customer_code = ?"
				+ ", received_address = ?"
				+ ", state = ?"
				+ ", form_of_payment = ?"
				+ ", paid_money = ?"
				+ ", unpaid_money = ?"
				+ ", ordered_date = ?"
				+ ", delivered_date = ?"
				+ " where order_code = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getOrderCode());
			pst.setString(2, t.getCustomer().getCustomerCode());
			pst.setString(3, t.getReceivedAddress());
			pst.setString(4, t.getState());
			pst.setString(5, t.getFormOfPayment());
			pst.setDouble(6, t.getPaidMoney());
			pst.setDouble(7, t.getUnpaidMoney());
			pst.setDate(8, t.getOrderedDay());
			pst.setDate(9, t.getDeliveredDay());

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
