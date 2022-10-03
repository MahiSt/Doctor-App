package com.doctorapp.dao;

import java.time.LocalDateTime;
import java.util.List;
import com.doctorapp.model.Doctor;

public interface IDoctorDao {
	int createTable();
	int addDoctor(Doctor doctor);
	int updateDoctor(int id,int fees);
	int deleteDoctor(int id);
	Doctor findById(int id);
	
	List<Doctor> findAllDoctors();
	List<Doctor> findBySeciality(String speciality);	
	List<Doctor> findByAvailability(LocalDateTime time);	
	List<Doctor> findByExperience(int experience);	
	List<Doctor> findBySecialityAndFees(String speciality,int fees);
	List<Doctor> findBySecialityAndExperience(String speciality,int experience);
}
