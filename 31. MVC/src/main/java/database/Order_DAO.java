package database;

import java.util.ArrayList;

import model.Order;

public class Order_DAO {
	private ArrayList<Order> data = new ArrayList<Order>();
	
	public ArrayList<Order> selectAll(){
		return data;
	}
	
	public Order selectById(String id) {
		Order search = new Order();
		search.setOrderCode(id);
		for (Order order : data) {
			if(order.equals(search)) {
				return order;
			}
		}
		return null;
	}
	
	public int insert(Order ord) {
		Order existedCheck = this.selectById(ord.getOrderCode());
		if (existedCheck == null) {
			data.add(existedCheck);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<Order> list) {
		int count = 0;
		for (Order order : list) {
			count += this.insert(order);
		}
		return count;
	}
	
	public int delete(Order ord) {
		Order existedCheck = this.selectById(ord.getOrderCode());
		if (existedCheck != null) {
			data.remove(existedCheck);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<Order> list) {
		int count = 0;
		for (Order order : list) {
			Order existedCheck = this.selectById(order.getOrderCode());
			if (existedCheck != null) {
				data.remove(order);
				count++;
			}
		}
		return count;
	}
	
	public int update(Order ord) {
		Order existedCheck = this.selectById(ord.getOrderCode());
		if (existedCheck != null) {
			data.remove(existedCheck);
			data.add(ord);
			return 1;
		} else {
			return 0;
		}
	}

}
