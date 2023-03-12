package model;

import java.util.Objects;

public class DetailedOrder {
	private String detailedOrderCode;
	private Product product;
	private Order order;
	private double quantity;
	private double discountPrice;
	private double sellingPrice;
	private double basisPrice;
	private double VAT;
	private double total;
	
	public DetailedOrder() {
	}

	public DetailedOrder(String detailedOrderCode, Product product, Order order, double quantity, double discountPrice, double sellingPrice, double basisPrice,
			double vAT, double total) {
		this.detailedOrderCode = detailedOrderCode;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
		this.discountPrice = discountPrice;
		this.sellingPrice = sellingPrice;
		this.basisPrice = basisPrice;
		VAT = vAT;
		this.total = total;
	}

	public String getDetailedOrderCode() {
		return detailedOrderCode;
	}

	public void setDetailedOrderCode(String detailedOrderCode) {
		this.detailedOrderCode = detailedOrderCode;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getBasisPrice() {
		return basisPrice;
	}

	public void setBasisPrice(double basisPrice) {
		this.basisPrice = basisPrice;
	}

	public double getVAT() {
		return VAT;
	}

	public void setVAT(double vAT) {
		VAT = vAT;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(detailedOrderCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailedOrder other = (DetailedOrder) obj;
		return Objects.equals(detailedOrderCode, other.detailedOrderCode);
	}
}
