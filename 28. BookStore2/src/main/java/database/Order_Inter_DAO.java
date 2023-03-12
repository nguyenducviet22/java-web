package database;

import java.util.ArrayList;

import model.DetailedOrder;
import model.Order;

public class Order_Inter_DAO implements Interface_DAO<Order> {
	private ArrayList<Order> data = new ArrayList<Order>();

	@Override
	public ArrayList<Order> selectAll() {
		return this.data;
	}

	@Override
	public Order selectById(Order t) {
		for (Order order : data) {
			if (data.equals(t))
				return order;
		}
		return null;
	}

	@Override
	public int insert(Order t) {
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
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
		if (this.selectById(t) != null) {
			DetailedOrder_DAO dod = new DetailedOrder_DAO();
			dod.deleteAll(t);
			this.data.remove(t);
			return 1;
		}
		return 0;
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
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
