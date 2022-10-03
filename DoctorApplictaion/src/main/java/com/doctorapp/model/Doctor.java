package com.doctorapp.model;

import java.time.LocalDateTime;

public class Doctor {
	private int doctorId;
	private String name;
	private String specialty;
	private int experience;
	private int fees;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	public Doctor() {
		super();
	}

	public Doctor(String name, String specialty, int experience, int fees, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.name = name;
		this.specialty = specialty;
		this.experience = experience;
		this.fees = fees;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", specialty=" + specialty + ", experience="
				+ experience + ", fees=" + fees + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}
	
	
	
}
