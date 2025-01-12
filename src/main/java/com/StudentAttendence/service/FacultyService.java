package com.StudentAttendence.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.StudentAttendence.Entity.Attendence_otp;
import com.StudentAttendence.Entity.Faculty;
import com.StudentAttendence.Entity.Student;
import com.StudentAttendence.Repository.AttendenceOtpRepo;
import com.StudentAttendence.Repository.FacultyRepo;
import com.StudentAttendence.Repository.StudentRepo;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepo facultyRepo;

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AttendenceOtpRepo otpRepo;

	public Optional<Student> getStudent(long id) {
		Optional<Student> std = studentRepo.findById(id);
		return std;
	}
	
	public Optional<Faculty> getFaculty(long id) {
		Optional<Faculty> faculty = facultyRepo.findById(id);
		return faculty;
	}

	public Faculty saveFaculty(Faculty faculty) {
		return facultyRepo.save(faculty);
	}
	
	
	public String saveStudent(Student student) {
	    
	    Random r = new Random();
		int r1 = r.nextInt(10);
		int r2 = r.nextInt(10);
		int r3 = r.nextInt(10);
		int r4 = r.nextInt(10);
		int r5 = r.nextInt(10);
		int r6 = r.nextInt(10);
		
		String pass = ""+r1+r2+r3+r4+r5+r6+"";
		
		student.setPassword(pass);
					
	    studentRepo.save(student);

	    return "Student saved successfully!";
	}


	public Student updateStudent(long id, Student std) {
		
		Optional<Student> oldStd = studentRepo.findById(id);

		if (oldStd.isPresent()) {
			return studentRepo.save(std);
			
		} else {
			
			throw new RuntimeException("Student not found with id = " + id) ;
		}
		
	}
	
	public String loginFaculty(long id, String username, int password)
	{
		Optional<Faculty> fac = facultyRepo.findById(id);
		
		if (fac.isPresent())
		{
			Faculty faculty = fac.get(); 
			if(username == faculty.getUsername() && password ==faculty.getPassword())
			{
				return " Username or password is incorrect";
			}
			else
			{
				return "Faculty login successful";
			}
		}
		else 
		{
		     return "Faculty is not registered";
		}
	}
	
	
	
	public String deleteStudent(long id)
	{
		
		Optional<Student> oldStd = studentRepo.findById(id);
		
		
		if (oldStd.isPresent()) {
			 studentRepo.deleteById(id);
			 return "Student deleted successfully";
			
		} else {
			
			throw new RuntimeException("Student not found with id = " + id) ;
		}
		
	}
	
	public String saveOtp(Attendence_otp otp)
	{
		otpRepo.save(otp);
		return "OTP saved successfully";
	}
	
	@Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        message.setFrom("chaitali.kul2002@gmail.com");
        mailSender.send(message);
    }
	
	

}
