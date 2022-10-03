package com.doctorapp.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.doctorapp.exceptions.DoctorNotFoundException;
import com.doctorapp.exceptions.IdNotFoundException;
import com.doctorapp.model.Doctor;
import com.doctorapp.model.Specialisation;
import com.doctorapp.service.DoctorServiceImpl;
import com.doctorapp.service.IDoctorService;

public class DoctorMain {
	
	public static void main(String[] args) {
		IDoctorService doctorService=new DoctorServiceImpl();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome...!!!!");
		boolean flag=true; 
		while(flag) {
			System.out.println("Select an option....");	
			System.out.println("1.Add a doctor \n2.Update \n3.Delete \n4.Get by Id \n5.Get all doctors \n6.Get by availability \n7.Get by experience \n8.Get by speciality \n9.Get by speciality and fees \n10.Get by speciality and experience \n11.Exit");
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			case 1:
				Doctor doctor=new Doctor();
				System.out.println("Enter the doctor details one by one...");
				System.out.println("Enter the name of the doctor:");
				doctor.setName(sc.nextLine());
				System.out.println("Select the Speciality: \n1.Orthopedian \n2.Pediatrician \n3.Diabeician \n4.Cardiologist \n5.General \n6.Physician");
				option=sc.nextInt();
				sc.nextLine();
				String specialisation=Specialisation.values()[option-1].type;
				doctor.setSpecialty(specialisation);
				System.out.println("Experience (in years):");
				doctor.setExperience(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter doctor fees:");
				doctor.setFees(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter the date and start time(yyyy-MM-dd HH:mm) that the doctor will available:");
				String dateTime=sc.nextLine();
				DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				doctor.setStartTime(LocalDateTime.parse(dateTime, dtf));
				System.out.println("Enter the date and end time(yyyy:MM:dd HH:mm) that the doctor will available:");
				dateTime=sc.nextLine();
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				doctor.setEndTime(LocalDateTime.parse(dateTime, dtf));

				int result=doctorService.addDoctor(doctor);
				if(result==1) {
					System.out.println("Updated successfully");
				}
				else {
					System.out.println("Enter correctly...");
				}
				break;
			case 2: 
				System.out.println("Enter the id of the doctor to be updated:");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the fees: ");
				int fees=sc.nextInt();
				
				try {
					result=doctorService.updateDoctor(id, fees);
					if(result==1) {
						System.out.println("Updated successfully");
					}
				} catch (IdNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 3: 
				System.out.println("Enter the id of the doctor to be deleted:");
				id=sc.nextInt();
				sc.nextLine();
				
				try {
					result=doctorService.deleteDoctor(id);
					if(result==1) {
						System.out.println("Deleted successfully");
					}
				} catch (IdNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4: 
				System.out.println("Enter the id:");
				id=sc.nextInt();
				sc.nextLine();
				doctor=null;
				try {
					doctor=doctorService.getById(id);
					System.out.println(doctor);
				} catch (IdNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				doctorService.getAllDoctors().forEach(System.out::println);
				break;
			case 6:
				System.out.println("Enter the date(yyyy-MM-dd HH:mm) and time expected:");
				dateTime=sc.nextLine();
				dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				try {
					doctorService.getByAvailability(LocalDateTime.parse(dateTime, dtf)).forEach(System.out::println);
				} catch (DoctorNotFoundException e) {
					e.printStackTrace();
				};
				break;
			case 7:
				System.out.println("Enter the expected no.of.years of experience:");
				int experience=sc.nextInt();
				sc.nextLine();
				
				try {
					doctorService.getByExperience(experience).forEach(System.out::println);
				} catch (DoctorNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 8:
				System.out.println("Select the Speciality: \n1.Orthopedian \n2.Pediatrician \n3.Diabeician \n4.Cardiologist \n5.General \n6.Physician");
				option=sc.nextInt();
				sc.nextLine();
				specialisation=Specialisation.values()[option-1].type;
				
				doctorService.getBySpeciality(specialisation).forEach(System.out::println);
				
				break;
			case 9:
				System.out.println("Select the Speciality: \n1.Orthopedian \n2.Pediatrician \n3.Diabeician \n4.Cardiologist \n5.General \n6.Physician");
				option=sc.nextInt();
				sc.nextLine();
				specialisation=Specialisation.values()[option-1].type;
				
				System.out.println("Enter the expected fees range:");
				fees=sc.nextInt();
				try {
					doctorService.getBySecialityAndFees(specialisation, fees).forEach(System.out::println);
				} catch (DoctorNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 10:
				System.out.println("Select the Speciality: \n1.Orthopedian \n2.Pediatrician \n3.Diabeician \n4.Cardiologist \n5.General \n6.Physician");
				option=sc.nextInt();
				sc.nextLine();
				specialisation=Specialisation.values()[option-1].type;
				
				System.out.println("Enter the expected no.of.years of experience:");
				experience=sc.nextInt();
				sc.nextLine();
				
				try {
					doctorService.getBySecialityAndExperience(specialisation, experience).forEach(System.out::println);
				} catch (DoctorNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 11:
				flag=false;
				break;
				default:
					System.out.println("Invaid option");
			}
		}
		sc.close();
	}
}
