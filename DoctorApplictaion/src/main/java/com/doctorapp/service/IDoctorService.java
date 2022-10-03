package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;

import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;

public interface IDoctorService {

	int addDoctor(Doctor doctor);
	int updateDoctor(int id,int fees) throws IdNotFoundException;
	int deleteDoctor(int id) throws IdNotFoundException;
	Doctor getById(int id) throws IdNotFoundException;
	
	List<Doctor> getAllDoctors();
	List<Doctor> getByAvailability(LocalDateTime time) throws DoctorNotFoundException;	
	List<Doctor> getByExperience(int experience) throws DoctorNotFoundException;	
	List<Doctor> getBySpeciality(String specialaity);		
	List<Doctor> getBySecialityAndFees(String specialaity,int feeRange) throws  DoctorNotFoundException;
	List<Doctor> getBySecialityAndExperience(String speciality,int experience) throws DoctorNotFoundException;
}
