package com.machoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.machoapp.model.User;
import com.machoapp.util.DbConnection;
import com.machoapp.util.UserQueries;

public class UserDaoImpl implements IUserDao{

	@Override
	public boolean addUser(User user) {
		Connection connection=DbConnection.openConnection();

		String sql=UserQueries.ADDUSERQUERY;
		boolean status=false;
		PreparedStatement statement=null;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setLong(3, user.getMobile());
			statement.setString(4, user.getLocation());
			statement.setString(5, user.getPassword());

			status=statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DbConnection.closeConnection();

		}
		return status;
	}

	@Override
	public User findByUserName(String userName, String password) {
		Connection connection=DbConnection.openConnection();

		String sql=UserQueries.LOGINQUERY;
		ResultSet resultSet=null;
		PreparedStatement statement=null;
		User user=new User();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, password);

			resultSet=statement.executeQuery();	
			while(resultSet.next()) {
				user.setUsername(resultSet.getString(2));
				user.setName(resultSet.getString(3));
				user.setMobile(resultSet.getLong(4));
				user.setLocation(resultSet.getString(5));
				user.setPassword(resultSet.getString(6));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbConnection.closeConnection();
			}
		}
		return user;
	}

	@Override
	public int changePassword(String userName,String password) {
		Connection connection=DbConnection.openConnection();

		String sql=UserQueries.CHANGEPASSWORDQUERRY;
		int status=0;
		PreparedStatement statement=null;

		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, userName);
			statement.setString(2, password);

			status=statement.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbConnection.closeConnection();
			}
		}
		return status;
	}


}
