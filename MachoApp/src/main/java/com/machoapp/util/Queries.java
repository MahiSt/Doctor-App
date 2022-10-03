package com.machoapp.util;

public class Queries {
	public static final String CREATEQUERRY="create table dress(productId int primary key Auto_increment,productName varchar(50),gender varchar(10),category varchar(20),material varchar(20),brand varchar(30),size varchar(10),color varchar(20),price DOUBLE PRECISION,rating DOUBLE PRECISION)";
	public static final String ADDQUERRY="Insert into dress(productName,gender,category,material,brand,size,color,price,rating) values(?,?,?,?,?,?,?,?,?)";
	public static final String UPDATEQUERRY="Update dress set price=? where productid=?";
	public static final String DELETEQUERRY="delete from dress where productid=?";
	public static final String QUERRYBYID="select* from dress where productid=?";
	public static final String QUERRYBYGENDER="select* from dress where gender=?";
	public static final String QUERRYGENDERANDCATEGORY="select* from dress where gender=? and category=?";
	public static final String QUERRYBYGENDERANDSIZE="select* from dress where gender=? and size=?";
	public static final String QUERRYBYCOLORANDCATEGORY="select* from dress where color=? and category=?";
	public static final String QUERRYBYMATERIALANDCATEGORY="select* from dress where material=? and category=?";
	public static final String QUERRYBYBRANDANDRATING="select* from dress where brand=? and rating>=?";
	public static final String QUERRYBYBRANDANDSIZE="select* from dress where brand=? and size=?";
	public static final String QUERRYBYCATEGORYANDPRICE="select* from dress where category=? and price<=?";
	public static final String QUERRYBYCATEGORYANDRATING="select* from dress where category=? and rating>=?";
		
}
