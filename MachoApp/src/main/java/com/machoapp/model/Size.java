package com.machoapp.model;

public enum Size {
	XS("Xs"),
	S("S"),
	M("M"),
	L("L"),
	XL("Xl"),
	XXL("XXl"),
	XXXL("XXXl"),
	FREESIZE("FreeSize");
	
	public String size;
	
	private Size(String size) {
		this.size=size;
	}
}
