package com.machoapp.service;

import com.machoapp.dao.IUserDao;
import com.machoapp.dao.UserDaoImpl;
import com.machoapp.exceptions.NotUniqueException;
import com.machoapp.exceptions.UserNotFoundException;
import com.machoapp.model.User;

public class UserServiceImpl implements IUserService {
	IUserDao userDao=new UserDaoImpl();
	
	@Override
	public boolean register(User user) throws NotUniqueException{
		boolean status= userDao.addUser(user);
		if(status)
			throw new NotUniqueException();
		
		return status;
	}

	@Override
	public User login(String userName, String password) throws UserNotFoundException {
		User user=userDao.findByUserName(userName, password);
		if(user==null)
			throw new UserNotFoundException();
		return user;
	}

	@Override
	public int changePassword(String userName,String password) {
		return userDao.changePassword(userName,password);
	}

}
