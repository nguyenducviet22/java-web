package database;

import java.util.ArrayList;

import model.Customer;

public class Customer_Inter_DAO implements Interface_DAO<Customer> {
	private ArrayList<Customer> data = new ArrayList<Customer>();

	@Override
	public ArrayList<Customer> selectAll() {
		return this.data;
	}

	@Override
	public Customer selectById(Customer t) {
		for (Customer customer : data) {
			if (customer.equals(t))
				return customer;
		}
		return null;
	}

	@Override
	public int insert(Customer t) {
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<Customer> arr) {
		int count =0;
		for (Customer customer : arr) {
			count += this.insert(customer);
		}
		return 0;
	}

	@Override
	public int delete(Customer t) {
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
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
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
