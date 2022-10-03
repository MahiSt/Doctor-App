package com.machoapp.service;

import com.machoapp.exceptions.NotUniqueException;
import com.machoapp.exceptions.UserNotFoundException;
import com.machoapp.model.User;

public interface IUserService {

	boolean register(User user) throws NotUniqueException;
	User login(String userName,String password) throws UserNotFoundException;
	int changePassword(String userName,String password);

}
