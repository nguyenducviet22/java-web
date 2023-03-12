package database;

import java.util.ArrayList;

import model.DetailedOrder;

public class DetailedOrder_DAO {
	private ArrayList<DetailedOrder> data = new ArrayList<DetailedOrder>();

	public ArrayList<DetailedOrder> selectAll() {
		return data;
	}

	public DetailedOrder selectById(String id) {
		DetailedOrder search = new DetailedOrder();
		search.setOrderedCode(id);
		for (DetailedOrder detailedOrder : data) {
			if (detailedOrder.equals(search)) {
				return detailedOrder;
			}
		}
		return null;
	}

	public int insert(DetailedOrder det) {
		DetailedOrder existedCheck = this.selectById(det.getOrderedCode());
		if (existedCheck == null) {
			data.add(det);
			return 1;
		} else {
			return 0;
		}
	}

	public int insertAll(ArrayList<DetailedOrder> list) {
		int count = 0;
		for (DetailedOrder detailedOrder : list) {
			count += this.insert(detailedOrder);
		}
		return count;
	}

	public int delete(DetailedOrder det) {
		DetailedOrder existedCheck = this.selectById(det.getOrderedCode());
		if (existedCheck != null) {
			data.remove(det);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<DetailedOrder> list) {
		int count = 0;
		for (DetailedOrder detailedOrder : list) {
			DetailedOrder existedCheck = this.selectById(detailedOrder.getOrderedCode());
			if (existedCheck != null) {
				data.remove(detailedOrder);
				count++;
			}
		}
		return count;
	}
	
	public int update(DetailedOrder det) {
		DetailedOrder existedCheck = this.selectById(det.getOrderedCode());
		if (existedCheck != null) {
			data.remove(existedCheck);
			data.add(det);
			return 1;
		} else {
			return 0;
		}
	}

}
