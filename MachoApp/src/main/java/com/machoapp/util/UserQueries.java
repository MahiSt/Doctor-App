package com.machoapp.util;

public class UserQueries {
	public static final String CREATETABLEQUERY="Create table user(userId int primary key Auto_Increment,userName varchar(30),name varchar(20),MobileNo int,Location varchar(50),password varchar(20), unique(userName)";
	
	public static final String ADDUSERQUERY="Insert into user(userName,name,MobileNo,Location,password) values(?,?,?,?,?)";
	public static final String LOGINQUERY="Select* from user where userName=? and password=?";
	public static final String CHANGEPASSWORDQUERRY="Update user set password=? where userName=?";

}
