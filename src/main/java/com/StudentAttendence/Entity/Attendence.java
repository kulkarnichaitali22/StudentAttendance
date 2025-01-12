package com.StudentAttendence.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Attendence {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
    private LocalDate date;
    
    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @OneToOne
    private Attendence_otp otp;
    
    
	public Attendence() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Attendence(LocalDate date, Student student, Attendence_otp otp) {
		super();
		this.date = date;
		this.student = student;
		this.otp = otp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Attendence_otp getOtp() {
		return otp;
	}
	public void setOtp(Attendence_otp otp) {
		this.otp = otp;
	}
	
    
}
