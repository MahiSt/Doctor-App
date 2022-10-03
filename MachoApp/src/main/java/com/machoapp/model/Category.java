package com.machoapp.model;

public enum Category {
	SHIRT("Shirt"),
	PANT("Pant"),
	TSHIRTS("T-Shirts"),
	HOODIES("Hoody"),
	LOWERS("Lowers"),
	CHUDI("Chudidhar"),
	SAREE("Saree"),
	LEGIN("Legin");
	
	public String category;
	
	private Category(String category) {
		this.category=category;
	}
}
