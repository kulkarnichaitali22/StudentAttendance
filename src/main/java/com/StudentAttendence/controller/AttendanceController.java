package com.StudentAttendence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAttendence.service.AttendanceService;

@RestController
@RequestMapping("attendance")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService;
	
	
	@PostMapping("/generateOtp/{studentId}/{facultyId}")
    public ResponseEntity<String> generateOtp(
            @PathVariable Long studentId,
            @PathVariable Long facultyId) 
	{
		String response = attendanceService.generateOtpForStudent(studentId, facultyId);
        return ResponseEntity.ok(response);
    }
	
	@PostMapping("markAttendance/{otp}/{studentId}")
	public String markAttendance(@PathVariable int otp, @PathVariable long studentId) {
		return attendanceService.markAttendance(otp, studentId);
	}


}



