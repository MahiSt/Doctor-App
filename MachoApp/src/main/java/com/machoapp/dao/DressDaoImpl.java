package com.machoapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.machoapp.model.Dress;
import com.machoapp.util.DbConnection;
import com.machoapp.util.IRowMapper;
import com.machoapp.util.Queries;
import com.machoapp.util.DressMapperImpl;

public class DressDaoImpl implements IDressDao {

	@Override
	public int addDress(Dress dress) {
		int result=0;
		
		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		String sql=Queries.ADDQUERRY;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, dress.getProductName());
			statement.setString(2, dress.getGender());
			statement.setString(3, dress.getCategory());
			statement.setString(4, dress.getMaterial());
			statement.setString(5, dress.getBrand());
			statement.setString(6, dress.getSize());
			statement.setString(7, dress.getColor());
			statement.setDouble(8, dress.getPrice());
			statement.setDouble(9, dress.getRating());

			result=statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DbConnection.closeConnection();
		}
		return result;
	}

	@Override
	public int updateDress(int productId, double price) {
		int result=0;
		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		String sql=Queries.UPDATEQUERRY;
		try {
			statement=connection.prepareStatement(sql);
			statement.setDouble(1, price);
			statement.setInt(2, productId);

			result=statement.executeUpdate();
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
		return result;
	}

	@Override
	public int deleteDress(int productId){
		int result=0;
		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		String sql=Queries.DELETEQUERRY;
		try {
			statement=connection.prepareStatement(sql);
			statement.setDouble(1, productId);

			result=statement.executeUpdate();
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
		return result;
	}

	@Override
	public Dress findById(int productId){
		Dress dress=new Dress();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYID;
		try {
			statement=connection.prepareStatement(sql);
			statement.setDouble(1, productId);

			resultSet=statement.executeQuery();

			IRowMapper map= new DressMapperImpl();
			dress=(map.rowMap(resultSet)).get(0);
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
		return dress;		
	}

	@Override
	public List<Dress> findByGender(String gender) {
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYGENDER;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, gender);

			resultSet=statement.executeQuery();
			IRowMapper map= new DressMapperImpl();
			dresses=map.rowMap(resultSet);
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

		return dresses;
	}

	@Override
	public List<Dress> findByGenderAndCategory(String gender, String category) {
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYGENDERANDCATEGORY;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, gender);
			statement.setString(2, category);

			resultSet=statement.executeQuery();
			IRowMapper map= new DressMapperImpl();
			dresses=map.rowMap(resultSet);
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

		return dresses;
	}

	@Override
	public List<Dress> findByGenderAndSize(String gender, String size) {
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		
		String sql=Queries.QUERRYBYGENDERANDSIZE;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, gender);
			statement.setString(2, size);

			resultSet=statement.executeQuery();
			
			IRowMapper map= new DressMapperImpl();
			dresses=map.rowMap(resultSet);
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
		return dresses;
	}

	@Override
	public List<Dress> findByColorAndCategory(String color, String category){
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYCOLORANDCATEGORY;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, color);
			statement.setString(2, category);

			resultSet=statement.executeQuery();
			
			IRowMapper map= new DressMapperImpl();
			dresses=map.rowMap(resultSet);
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

		return dresses;
	}

	@Override
	public List<Dress> findByMaterialAndCategory(String material, String category) {
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYMATERIALANDCATEGORY;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, material);
			statement.setString(2, category);

			resultSet=statement.executeQuery();
	
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

		return dresses;
	}

	@Override
	public List<Dress> findByBrandAndRating(String brand, double rating) {
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYBRANDANDRATING;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, brand);
			statement.setDouble(2, rating);

			resultSet=statement.executeQuery();
	
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

		return dresses;
	}

	@Override
	public List<Dress> findByBrandAndSize(String brand, String size) {
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYBRANDANDSIZE;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, brand);
			statement.setString(2, size);

			resultSet=statement.executeQuery();
	
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

		return dresses;
	}

	@Override
	public List<Dress> findByCategoryAndPrice(String category, double price){
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYCATEGORYANDPRICE;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, category);
			statement.setDouble(2, price);

			resultSet=statement.executeQuery();
	
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

		return dresses;
	}

	@Override
	public List<Dress> findByCategoryAndRating(String category, double rating) {
		List<Dress> dresses=new ArrayList<>();

		Connection connection=DbConnection.openConnection();
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		String sql=Queries.QUERRYBYCATEGORYANDRATING;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, category);
			statement.setDouble(2, rating);

			resultSet=statement.executeQuery();
	
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
		return dresses;
	}


}
