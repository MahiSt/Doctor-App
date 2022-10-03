package com.doctorapp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.doctorapp.dao.DoctorDaoImpl;
import com.doctorapp.dao.IDoctorDao;
import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;

public class DoctorServiceImpl implements IDoctorService{

	IDoctorDao doctorDao=new DoctorDaoImpl();
	public int addDoctor(Doctor doctor) {
		return doctorDao.addDoctor(doctor);
	}

	public int updateDoctor(int id, int fees) throws IdNotFoundException{
		int result=doctorDao.updateDoctor(id, fees);
		if(result==0) {
			throw new IdNotFoundException("Entered Id is not found");
		}
		return result;
	}

	public Doctor getById(int id) throws IdNotFoundException{
		Doctor doctor= doctorDao.findById(id);
		if(doctor.equals(null)) {
			throw new IdNotFoundException("Entered Id is not found");
		}
		return doctor;
	}

	public int deleteDoctor(int id) throws IdNotFoundException{
		int result=doctorDao.deleteDoctor(id);
		if(result==0) {
			throw new IdNotFoundException("Entered Id is not found");
		}
		return result;
	}

	public List<Doctor> getAllDoctors() {
		return doctorDao.findAllDoctors().stream()
				.sorted((doc1,doc2)->{
					return doc1.getName().compareTo(doc2.getName());
				})
				.collect(Collectors.toList());		
	}

	@Override
	public List<Doctor> getByAvailability(LocalDateTime time) throws DoctorNotFoundException {
		System.out.println("1");
		List<Doctor> doctors= doctorDao.findByAvailability(time).stream()
				.sorted((doc1,doc2)->{
					return doc1.getName().compareTo(doc2.getName());
				})
				.collect(Collectors.toList());	
		System.out.println("3");

		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("No doctor is availabe on the specified time");
		}
		System.out.println("in service");
		return doctors;
	}

	@Override
	public List<Doctor> getByExperience(int experience) throws DoctorNotFoundException {
		List<Doctor> doctors= doctorDao.findByExperience(experience).stream()
				.sorted((doc1,doc2)->{
					return doc1.getName().compareTo(doc2.getName());
				})
				.collect(Collectors.toList());		
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("No doctor found with expected experience");
		}
		return doctors;
	}
	public List<Doctor> getBySpeciality(String speciality) {
		List<Doctor> doctors= doctorDao.findBySeciality(speciality).stream()
				.sorted((doc1,doc2)->{
					return doc1.getName().compareTo(doc2.getName());
				})
				.collect(Collectors.toList());		
		return doctors;
	}

	public List<Doctor> getBySecialityAndFees(String speciality,int fees) throws DoctorNotFoundException {
		List<Doctor> doctors=doctorDao.findBySecialityAndFees(speciality,fees).stream()
				.sorted((doc1,doc2)->{
					return doc1.getName().compareTo(doc2.getName());
				})
				.collect(Collectors.toList());		
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("Sorry!!!....No doctors found on the seleced categories...");
		}
		return doctors;
	}

	public List<Doctor> getBySecialityAndExperience(String speciality,int experience) throws DoctorNotFoundException {
		List<Doctor> doctors=doctorDao.findBySecialityAndExperience(speciality,experience).stream()
				.sorted((doc1,doc2)->{
					return doc1.getName().compareTo(doc2.getName());
				})
				.collect(Collectors.toList());		
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("Sorry!!!....No doctors found on the seleced categories...");
		}
		return doctors;
	}

	public List<Doctor> fgetByAvailability(LocalDateTime time) throws DoctorNotFoundException {
		List<Doctor> doctors= doctorDao.findByAvailability(time).stream()
				.sorted((doc1,doc2)->{
					return doc1.getName().compareTo(doc2.getName());
				})
				.collect(Collectors.toList());		
		if(doctors.isEmpty()) {
			throw new DoctorNotFoundException("Sorry!!!....No doctors found on the seleced categories...");
		}
		return doctors;
	}

}
