package database;

import java.util.ArrayList;

import model.Customer;

public class Customer_DAO {
	private ArrayList<Customer> data = new ArrayList<Customer>();

	public ArrayList<Customer> selectAll() {
		return data;
	}

	public Customer selectById(String id) {
		Customer search = new Customer();
		search.setCustomerCode(id);
		for (Customer customer : data) {
			if (customer.equals(search))
				return customer;
		}
		return null;
	}

	public int insert(Customer cus) {
		Customer existedCheck = this.selectById(cus.getCustomerCode());
		if (existedCheck == null) {
			data.add(cus);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<Customer> list) {
		int count = 0;
		for (Customer customer : list) {
			count += this.insert(customer);
		}
		return count;
	}

	public int delete(Customer cus) {
		Customer existedCheck = this.selectById(cus.getCustomerCode());
		if (existedCheck != null) {
			data.remove(cus);
			return 1;
		} else {
			return 0;
		}
	}

	public int deleteAll(ArrayList<Customer> list) {
		int count = 0;
		for (Customer customer : list) {
			Customer existedCheck = this.selectById(customer.getCustomerCode());
			if (existedCheck != null) {
				data.remove(customer);
				count++;
			}
		}
		return count;
	}

	public int update(Customer cus) {
		Customer existedCheck = this.selectById(cus.getCustomerCode());
		if (existedCheck != null) {
			data.remove(existedCheck);
			data.add(cus);
			return 1;
		} else {
			return 0;
		}
	}

}
