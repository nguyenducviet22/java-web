package model;

import java.util.Objects;

public class Product {
	private String productCode;
	private String nameOfProduct;
	private Author author;
	private int publishedYear;
	private double importPrice;
	private double sellingPrice;
	private double basisPrice;
	private int quantity;
	private Genre genre;
	private String language;
	private String description;

	public Product() {
	}

	public Product(String productCode, String nameOfProduct, Author author, int publishedYear, double importPrice,
			double sellingPrice, double basisPrice, int quantity, Genre genre, String language, String description) {
		this.productCode = productCode;
		this.nameOfProduct = nameOfProduct;
		this.author = author;
		this.publishedYear = publishedYear;
		this.importPrice = importPrice;
		this.sellingPrice = sellingPrice;
		this.basisPrice = basisPrice;
		this.quantity = quantity;
		this.genre = genre;
		this.language = language;
		this.description = description;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getNameOfProduct() {
		return nameOfProduct;
	}

	public void setNameOfProduct(String nameOfProduct) {
		this.nameOfProduct = nameOfProduct;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

	public double getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(double importPrice) {
		this.importPrice = importPrice;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productCode, other.productCode);
	}

	
}
