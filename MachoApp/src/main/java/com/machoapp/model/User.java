package com.machoapp.model;

public class User {

	private int userId;//(pk)
	private String username; //(unique)
	private String name;
	private long mobile;
	private String location;
	private String password;
	private byte loginType;

	public User() {
		super();
	}

	public User(String username, String name, long mobile, String location, String password,byte loginType) {
		super();
		this.username = username;
		this.name = name;
		this.mobile = mobile;
		this.location = location;
		this.password = password;
		this.loginType=loginType;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public byte getLoginType() {
		return loginType;
	}

	public void setLoginType(byte loginType) {
		this.loginType = loginType;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", name=" + name + ", mobile=" + mobile
				+ ", location=" + location + ", password=" + password + ", loginType=" + loginType + "]";
	}
	
}
