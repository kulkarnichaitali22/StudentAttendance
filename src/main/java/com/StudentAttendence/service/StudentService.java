package com.StudentAttendence.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentAttendence.Entity.Attendence_otp;
import com.StudentAttendence.Entity.Student;
import com.StudentAttendence.Repository.AttendenceOtpRepo;
import com.StudentAttendence.Repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AttendenceOtpRepo otpRepo;
	
	public String loginStudent(long id, String username, String password)
	{
		Optional<Student> std = studentRepo.findById(id);
		
		if (std.isPresent())
		{
			Student student = std.get(); 
			if(username == student.getUsername() && password.equals(student.getPassword()))
			{
				return "Student login successful";
			}
			else
			{
				return "Username or password is incorrect";
			}
		}
		else 
		{
		     return "Student is not registered";
		}
	}
	
	
	
	public Optional<Student> getStudent(long id)
	{
		Optional<Student> std = studentRepo.findById(id);
		return std;
	}
	
	

}
