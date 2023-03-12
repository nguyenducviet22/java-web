package database;

import java.util.ArrayList;

import model.DetailedOrder;
import model.Order;

public class DetailedOrder_Inter_DAO implements Interface_DAO<DetailedOrder> {
	private ArrayList<DetailedOrder> data = new ArrayList<DetailedOrder>();

	@Override
	public ArrayList<DetailedOrder> selectAll() {
		return this.data;
	}

	@Override
	public DetailedOrder selectById(DetailedOrder t) {
		for (DetailedOrder detailedOrder : data) {
			if (detailedOrder.equals(t))
				return detailedOrder;
		}
		return null;
	}

	@Override
	public int insert(DetailedOrder t) {
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int insertAll(ArrayList<DetailedOrder> arr) {
		int count =0;
		for (DetailedOrder detailedOrder : arr) {
			count += this.insert(detailedOrder);
		}
		return 0;
	}

	@Override
	public int delete(DetailedOrder t) {
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteAll(ArrayList<DetailedOrder> arr) {
		int count = 0;
		for (DetailedOrder detailedOrder : arr) {
			count += this.delete(detailedOrder);
		}
		return count;
	}
	
	public int deleteAll(Order ord) {
		int count = 0;
		for (DetailedOrder detailedOrder : data) {
			if (detailedOrder.getOrder().equals(ord)) {
				this.delete(detailedOrder);
			}
		}
		return count;
	}
	
	
	@Override
	public int update(DetailedOrder t) {
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
