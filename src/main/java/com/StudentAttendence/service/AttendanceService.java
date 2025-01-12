package com.StudentAttendence.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentAttendence.Entity.Attendence;
import com.StudentAttendence.Entity.Attendence_otp;
import com.StudentAttendence.Entity.Faculty;
import com.StudentAttendence.Entity.Student;
import com.StudentAttendence.Repository.AttendanceRepo;
import com.StudentAttendence.Repository.AttendenceOtpRepo;
import com.StudentAttendence.Repository.FacultyRepo;
import com.StudentAttendence.Repository.StudentRepo;

@Service
public class AttendanceService {

	@Autowired
	private AttendenceOtpRepo otpRepo;

	@Autowired
	private AttendanceRepo attendanceRepo;

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private FacultyRepo facultyRepo;

	public String generateOtpForStudent(Long studentId, Long facultyId) {

		Student student = studentRepo.findById(studentId).orElse(null);
		Faculty faculty = facultyRepo.findById(facultyId).orElse(null);

		if (student == null) {
			System.out.println("Student not found.");
		}

		if (faculty == null) {
			System.out.println("Student not found.");
		}

		int otp = (int) ((long) (Math.random() * 900000) + 100000);

		Attendence_otp attendanceOtp = new Attendence_otp();
		attendanceOtp.setDate(LocalDate.now());
		attendanceOtp.setOtp(otp);
		attendanceOtp.setFaculty(faculty);
		otpRepo.save(attendanceOtp);

		// Create and update Attendance
		Attendence attendance = new Attendence();
		attendance.setDate(LocalDate.now());
		attendance.setStudent(student);
		attendance.setOtp(attendanceOtp);
		attendanceRepo.save(attendance);

		return "OTP " + otp + " has been generated for student " ;
	}

	public String markAttendance(int otp, long studentId) {
		
		// Fetch the student from the database
	    Optional<Student> oldStd = studentRepo.findById(studentId);
	    
	    if(oldStd.isPresent())
	    {
	    	
	    	Student std = oldStd.get();
	    	long num = std.getId();
	    	
	    	
	    	
	    	if(oldStd.get().getId() == otp) 
	    	{
	    		return "Entered Wrong OTP";
	    	}
	    	else
	    	{
	    		return "Student attendence is marked";
	    	}
	    
	    }
	    else
	    {
	    	return "Invalid Student"; 
	    }
	}
}
