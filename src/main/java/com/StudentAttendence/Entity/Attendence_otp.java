package com.StudentAttendence.Entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Attendence_otp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDate date;
	private int otp;
	
	@OneToOne
	@JoinColumn(name = "faculty_id", nullable=false)
	private Faculty faculty;
	
	
	public Attendence_otp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendence_otp(LocalDate date, int otp) {
		super();
		this.date = date;
		this.otp = otp;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	

	
	
	
	
}
