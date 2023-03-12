package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Customer;

public class Customer_Inter_DAO implements Interface_DAO<Customer> {

	@Override
	public ArrayList<Customer> selectAll() {
		ArrayList<Customer> result = new ArrayList<Customer>();
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from customer";
			PreparedStatement pst = con.prepareStatement(sql);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String customerCode = rs.getString("customer_code");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("full_name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String receivedAddress = rs.getString("received_address");
				Date dateOfBirth = rs.getDate("date_of_birth");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");

				Customer customer = new Customer(customerCode, username, password, fullName, gender, address,
						receivedAddress, dateOfBirth, phoneNumber, email);
				result.add(customer);
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
	public Customer selectById(Customer t) {
		Customer result = null;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from customer where customer_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCustomerCode());

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String customerCode = rs.getString("customer_code");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("full_name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String receivedAddress = rs.getString("received_address");
				Date dateOfBirth = rs.getDate("date_of_birth");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String verifyCode = rs.getString("verify_code");
				Date validPeriod = rs.getDate("valid_period");
				boolean verifyState = rs.getBoolean("verify_state");

				result = new Customer(customerCode, username, password, fullName, gender, address, receivedAddress,
						dateOfBirth, phoneNumber, email, verifyCode, validPeriod, verifyState);

			}

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	public Customer selectByUsernameAndPassword(Customer t) {
		Customer result = null;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from customer where username=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getPassword());

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				String customerCode = rs.getString("customer_code");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String fullName = rs.getString("full_name");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String receivedAddress = rs.getString("received_address");
				Date dateOfBirth = rs.getDate("date_of_birth");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String verifyCode = rs.getString("verify_code");
				Date validPeriod = rs.getDate("valid_period");
				boolean verifyState = rs.getBoolean("verify_state");

				result = new Customer(customerCode, username, password, fullName, gender, address, receivedAddress,
						dateOfBirth, phoneNumber, email, verifyCode, validPeriod, verifyState);
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
	public int insert(Customer t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "insert into customer (customer_code, username, password, full_name, gender, address, received_address, date_of_birth, phone_number, email)"
					+ "value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCustomerCode());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPassword());
			pst.setString(4, t.getFullName());
			pst.setString(5, t.getGender());
			pst.setString(6, t.getAddress());
			pst.setString(7, t.getReceivedAddress());
			pst.setDate(8, t.getDateOfBirth());
			pst.setString(9, t.getPhoneNumber());
			pst.setString(10, t.getEmail());

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
	public int insertAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer customer : arr) {
			count += this.insert(customer);
		}
		return count;
	}

	@Override
	public int delete(Customer t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "delete from product where product_code=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCustomerCode());

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
	public int deleteAll(ArrayList<Customer> arr) {
		int count = 0;
		for (Customer customer : arr) {
			count += this.delete(customer);
		}
		return count;
	}

	@Override
	public int update(Customer t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update customer " + " set " + " username = ?" + ", password = ?" + ", full_name = ?"
					+ ", gender = ?" + ", address = ?" + ", received_address = ?" + ", date_of_birth = ?"
					+ ", phone_number = ?" + ", email = ?" + " where customer_code = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getCustomerCode());
			pst.setString(2, t.getUsername());
			pst.setString(3, t.getPassword());
			pst.setString(4, t.getFullName());
			pst.setString(5, t.getGender());
			pst.setString(6, t.getAddress());
			pst.setString(7, t.getReceivedAddress());
			pst.setDate(8, t.getDateOfBirth());
			pst.setString(9, t.getPhoneNumber());
			pst.setString(10, t.getEmail());

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

	public boolean checkUsername(String username) {
		boolean result = false;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "select * from customer where username=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, username);

			// #3 conduct SQL command
			System.out.println(sql);
			ResultSet rs = pst.executeQuery();

			// #4
			while (rs.next()) {
				result = true;
			}

			// #5 stop connection with CSDL
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	// lesson 34
	public boolean changePassword(Customer t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update customer " + " set " + " password = ?" + " where customer_code = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getPassword());
			pst.setString(2, t.getCustomerCode());

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
		return result > 0;
	}

	// lesson 35
	public int updateInfo(Customer t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update customer " + " set " + " full_name = ?" + ", gender = ?" + ", address = ?"
					+ ", received_address = ?" + ", date_of_birth = ?" + ", phone_number = ?" + ", email = ?"
					+ " where customer_code = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getFullName());
			pst.setString(2, t.getGender());
			pst.setString(3, t.getAddress());
			pst.setString(4, t.getReceivedAddress());
			pst.setDate(5, t.getDateOfBirth());
			pst.setString(6, t.getPhoneNumber());
			pst.setString(7, t.getEmail());
			pst.setString(8, t.getCustomerCode());

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

	// lesson 39 verify email
	public int updateVerifyEmail(Customer t) {
		int result = 0;
		try {
			// #1 create connection with CSDL
			Connection con = JDBCUtil.getConnection();

			// #2 create SQL command and PreparedStatement
			String sql = "update customer " + " set " + " verify_code = ?" + ", valid_period = ?" + ", verify_state = ?"
					+ " where customer_code = ?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getVerifyCode());
			pst.setDate(2, t.getValidPeriod());
			pst.setBoolean(3, t.isVerifyState());
			pst.setString(4, t.getCustomerCode());

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
