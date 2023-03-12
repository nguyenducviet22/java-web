package entity;//= package model

public class Product {
	private int productId;
	private String productName;
	private String productImage;
	private double productPrice;
	private String productTitle;
	private String productDescription;
	
	public Product() {
	}

	public Product(int productId, String productName, String productImage, double productPrice, String productTitle,
			String productDescription) {
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.productPrice = productPrice;
		this.productTitle = productTitle;
		this.productDescription = productDescription;
	}

	public int getProductIdId() {
		return productId;
	}

	public void setProductIdId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", productPrice=" + productPrice + ", productTitle=" + productTitle + ", productDescription="
				+ productDescription + "]";
	}

	
}
