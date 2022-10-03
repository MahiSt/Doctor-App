package com.doctorapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.doctorapp.model.Doctor;
import com.doctorapp.util.DbConection;
import com.doctorapp.util.Queries;

public class DoctorDaoImpl implements IDoctorDao {

	@Override
	public int createTable() {
		Connection connection=DbConection.openConnection() ;
		PreparedStatement statement=null;
		String sql =Queries.CREATEQUERY ;
		int result=0;
		try {
			statement=connection.prepareStatement(sql);
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
			DbConection.closeConnection();
		}
		return result;
	}

	@Override
	public int addDoctor(Doctor doctor) {
		Connection connection=DbConection.openConnection();
		PreparedStatement statement=null;
		String sql=Queries.ADDQUERY;
		int result=0;
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, doctor.getName());
			statement.setString(2, doctor.getSpecialty());
			statement.setInt(3, doctor.getExperience());
			statement.setInt(4, doctor.getFees());
			statement.setTimestamp(5, Timestamp.valueOf(doctor.getStartTime()));
			statement.setTimestamp(6, Timestamp.valueOf(doctor.getEndTime()));
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
			DbConection.closeConnection();
		}		
		return result;
	}

	@Override
	public int updateDoctor(int id, int fees) {
		Connection connection=DbConection.openConnection();
		String sql=Queries.UPDATEQUERY;
		PreparedStatement statement=null;
		int result=0;
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.setInt(2, result);
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
			DbConection.closeConnection();
		}
		return result;
	}

	@Override
	public Doctor findById(int id) {
		Connection connection=DbConection.openConnection();
		String sql=Queries.GETBYID;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		Doctor doctor =new Doctor();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				doctor.setName(resultSet.getString(2)); 
				doctor.setSpecialty(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getInt(5));
				Timestamp timeStamp=resultSet.getTimestamp(6);
				doctor.setStartTime(timeStamp.toLocalDateTime());
				timeStamp=resultSet.getTimestamp(7);
				doctor.setEndTime(timeStamp.toLocalDateTime());				
			}	
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
			DbConection.closeConnection();
		}
		return doctor;
	}

	@Override
	public int deleteDoctor(int id) {
		Connection connection=DbConection.openConnection();
		String sql=Queries.DELETEQUERY;
		PreparedStatement statement=null;
		int result=0;
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
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
			DbConection.closeConnection();
		}
		return result;
		
	}

	@Override
	public List<Doctor> findAllDoctors() {
		Connection connection=DbConection.openConnection();
		String sql=Queries.GETALLQUERY;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		List<Doctor> doctors=new ArrayList<>();
		try {
			statement=connection.prepareStatement(sql);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor =new Doctor();
				doctor.setName(resultSet.getString(2)); 
				doctor.setSpecialty(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getInt(5));
				Timestamp timeStamp=resultSet.getTimestamp(6);
				doctor.setStartTime(timeStamp.toLocalDateTime());
				timeStamp=resultSet.getTimestamp(7);
				doctor.setEndTime(timeStamp.toLocalDateTime());		
				doctors.add(doctor);
			}	
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
			DbConection.closeConnection();
		}
		return doctors;
	}

	@Override
	public List<Doctor> findByAvailability(LocalDateTime localeTime){
		Connection connection=DbConection.openConnection();
		String sql=Queries.GETBYAVAILABLITY;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		List<Doctor> doctors=new ArrayList<>();
		try {
			statement=connection.prepareStatement(sql);
			Timestamp time = Timestamp.valueOf(localeTime);
			statement.setTimestamp(1, time);
			//System.out.println(Timestamp.valueOf(localeTime)+"   456");
			resultSet=statement.executeQuery();

			//System.out.println(resultSet.next());
			
			while(resultSet.next()) {
				Doctor doctor =new Doctor();
				doctor.setName(resultSet.getString(2)); 
				doctor.setSpecialty(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getInt(5));
				Timestamp timeStamp=resultSet.getTimestamp(6);
				doctor.setStartTime(timeStamp.toLocalDateTime());
				timeStamp=resultSet.getTimestamp(7);
				doctor.setEndTime(timeStamp.toLocalDateTime());		
				doctors.add(doctor);
			}	
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
			DbConection.closeConnection();
		}
		System.out.println("2");
		doctors.forEach(System.out::println);
		return doctors;
	}

	@Override
	public List<Doctor> findByExperience(int experience) {
		Connection connection=DbConection.openConnection();
		String sql=Queries.GETBYEXPERIENCE;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		List<Doctor> doctors=new ArrayList<>();
		try {
			statement=connection.prepareStatement(sql);
			statement.setInt(1, experience);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor =new Doctor();
				doctor.setName(resultSet.getString(2)); 
				doctor.setSpecialty(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getInt(5));
				Timestamp timeStamp=resultSet.getTimestamp(6);
				doctor.setStartTime(timeStamp.toLocalDateTime());
				timeStamp=resultSet.getTimestamp(7);
				doctor.setEndTime(timeStamp.toLocalDateTime());		
				doctors.add(doctor);
			}	
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
			DbConection.closeConnection();
		}
		return doctors;
	}
	@Override
	public List<Doctor> findBySeciality(String speciality) {
		Connection connection=DbConection.openConnection();
		String sql=Queries.GETBYSPECIALITY;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		List<Doctor> doctors=new ArrayList<>();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, speciality);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor =new Doctor();
				doctor.setName(resultSet.getString(2)); 
				doctor.setSpecialty(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getInt(5));
				Timestamp timeStamp=resultSet.getTimestamp(6);
				doctor.setStartTime(timeStamp.toLocalDateTime());
				timeStamp=resultSet.getTimestamp(7);
				doctor.setEndTime(timeStamp.toLocalDateTime());		
				doctors.add(doctor);
			}	
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
			DbConection.closeConnection();
		}
		return doctors;
	}

	@Override
	public List<Doctor> findBySecialityAndFees(String speciality, int fees){
		Connection connection=DbConection.openConnection();
		String sql=Queries.GETBYSPECIALITYANDFEES;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		List<Doctor> doctors=new ArrayList<>();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, speciality);
			statement.setInt(2, fees);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor =new Doctor();
				doctor.setName(resultSet.getString(2)); 
				doctor.setSpecialty(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getInt(5));
				Timestamp timeStamp=resultSet.getTimestamp(6);
				doctor.setStartTime(timeStamp.toLocalDateTime());
				timeStamp=resultSet.getTimestamp(7);
				doctor.setEndTime(timeStamp.toLocalDateTime());		
				doctors.add(doctor);
			}	
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
			DbConection.closeConnection();
		}
		return doctors;
	}

	@Override
	public List<Doctor> findBySecialityAndExperience(String speciality, int experience){
		Connection connection=DbConection.openConnection();
		String sql=Queries.GETBYSPECIALITYANDEXPERIENCE;
		PreparedStatement statement=null;
		ResultSet resultSet=null;
		List<Doctor> doctors=new ArrayList<>();
		try {
			statement=connection.prepareStatement(sql);
			statement.setString(1, speciality);
			statement.setInt(2, experience);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				Doctor doctor =new Doctor();
				doctor.setName(resultSet.getString(2)); 
				doctor.setSpecialty(resultSet.getString(3));
				doctor.setExperience(resultSet.getInt(4));
				doctor.setFees(resultSet.getInt(5));
				Timestamp timeStamp=resultSet.getTimestamp(6);
				doctor.setStartTime(timeStamp.toLocalDateTime());
				timeStamp=resultSet.getTimestamp(7);
				doctor.setEndTime(timeStamp.toLocalDateTime());		
				doctors.add(doctor);
			}	
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
			DbConection.closeConnection();
		}
		return doctors;
	}


}
