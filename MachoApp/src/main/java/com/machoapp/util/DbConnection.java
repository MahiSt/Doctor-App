package com.machoapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static Connection connection=null;
	
	public static Connection openConnection() {
		String url="jdbc:mysql://localhost:3306/dress";
		String userName="root";
		String password="root";
		try {
			connection=DriverManager.getConnection(url,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection() {
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
