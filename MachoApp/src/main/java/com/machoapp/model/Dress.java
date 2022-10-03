package com.machoapp.model;

public class Dress {
	private Integer productId;
	private String  productName;
	private String gender;
	private String category;
	private String material; 
	private String brand;
	private String size;
	private String color;
	private double price;
	private double rating;
	
	public Dress() {
		super();
	}
	
	public Dress(String productName, String gender, String category, String material, String brand, String size,
			String color, double price, double rating) {
		super();
		this.productName = productName;
		this.gender = gender;
		this.category = category;
		this.material = material;
		this.brand = brand;
		this.size = size;
		this.color = color;
		this.price = price;
		this.rating = rating;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Dress [productName=" + productName + ", gender=" + gender + ", category=" + category + ", material="
				+ material + ", brand=" + brand + ", size=" + size + ", color=" + color + ", price=" + price
				+ ", rating=" + rating + "]";
	}
	
	

}
