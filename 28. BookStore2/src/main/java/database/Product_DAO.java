package database;

import java.util.ArrayList;

import model.Product;

public class Product_DAO {
	private ArrayList<Product> data = new ArrayList<Product>();

	public ArrayList<Product> selectAll() {
		return data;
	}

	public Product selectById(String id) {
		Product search = new Product();
		search.setProductCode(id);
		for (Product product : data) {
			if (product.equals(search)) {
				return product;
			}
		}
		return null;
	}
	
	public int insert(Product pro) {
		Product existedCheck = this.selectById(pro.getProductCode());
		if (existedCheck == null) {
			data.add(pro);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int insertAll(ArrayList<Product> list) {
		int count =0;
		for (Product product : list) {
			if(product != null)
				count += this.insert(product);
		}
		return count;
	}
	
	public int delete(Product pro) {
		Product existedCheck = this.selectById(pro.getProductCode());
		if (existedCheck != null) {
			data.remove(pro);
			return 1;
		} else {
			return 0;
		}
	}
	
	public int deleteAll(ArrayList<Product> list) {
		int count = 0;
		for (Product product : list) {
			Product existedCheck = this.selectById(product.getProductCode());
			if (existedCheck != null) {
				data.remove(product);
				count++;
			}
		}
		return count;
	}
	
	public int update(Product pro) {
		Product existedCheck = this.selectById(pro.getProductCode());
		if (existedCheck != null) {
			data.remove(existedCheck);
			data.add(pro);
			return 1;
		} else {
			return 0;
		}
	}

}
