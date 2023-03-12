package database;

import java.util.ArrayList;

import model.Product;

public class Product_Inter_DAO implements Interface_DAO<Product> {
	private ArrayList<Product> data = new ArrayList<Product>();

	@Override
	public ArrayList<Product> selectAll() {
		return this.data;
	}

	@Override
	public Product selectById(Product t) {
		for (Product product : data) {
			if (data.equals(t))
				return product;
		}
		return null;
	}

	@Override
	public int insert(Product t) {
		if (this.selectById(t) == null) {
			this.data.add(t);
			return 1;
		}
		return 0;
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
		if (this.selectById(t) != null) {
			this.data.remove(t);
			return 1;
		}
		return 0;
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
		if (this.selectById(t) != null) {
			this.data.remove(t);
			this.data.add(t);
			return 1;
		}
		return 0;
	}

}
