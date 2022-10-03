package com.machoapp.dao;

import com.machoapp.model.User;

public interface IUserDao {
	boolean addUser(User user);
	User findByUserName(String userName,String password);
	int changePassword(String userName,String password);
}
