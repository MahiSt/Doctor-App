package com.machoapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.machoapp.model.Dress;

public class DressMapperImpl implements IRowMapper{

	@Override
	public List<Dress> rowMap(ResultSet resultSet) throws SQLException {
		List<Dress> dresses=new ArrayList<>();
		
		while(resultSet.next()) {
			Dress dress=new Dress();

			dress.setProductName(resultSet.getString(2));
			dress.setGender(resultSet.getString(3));
			dress.setCategory(resultSet.getString(4));
			dress.setMaterial(resultSet.getString(5));
			dress.setBrand(resultSet.getString(6));
			dress.setSize(resultSet.getString(7));
			dress.setColor(resultSet.getString(8));
			dress.setPrice(resultSet.getDouble(9));
			dress.setRating(resultSet.getDouble(10));				
			
			dresses.add(dress);
		}
		
		return dresses;
	}

}
