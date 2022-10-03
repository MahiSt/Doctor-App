package com.doctorapp.util;

public class Queries {
	public static final String CREATEQUERY="Create table doctor(doctorId int primary key Auto_increment,name varchar(20),speciality varchar(20),experience int,fees double,startTime Timestamp,endTime Timestamp)";
	public static final String ADDQUERY="Insert into doctor(name,speciality,experience,fees,startTime,endTime) values (?,?,?,?,?,?)";
	public static final String UPDATEQUERY="Update doctor set fees=? where doctorId=?";
	public static final String GETBYID="Select* from doctor where doctorid=?";
	public static final String DELETEQUERY="delete from doctor where doctorId=?";
	
	public static final String GETALLQUERY="Select* from doctor";
	public static final String GETBYAVAILABLITY="Select* from doctor where startTime>=?";
	public static final String GETBYSPECIALITY="Select* from doctor where speciality=?";
	public static final String GETBYEXPERIENCE="Select* from doctor where experience>=?";
	public static final String GETBYSPECIALITYANDFEES="Select* from doctor where Speciality=? and fees<=?+500";
	public static final String GETBYSPECIALITYANDEXPERIENCE="Select* from doctor where speciality=? and experience>=?";
}
