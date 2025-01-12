package com.StudentAttendence.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentAttendence.Entity.Attendence_otp;

@Repository
public interface AttendenceOtpRepo extends JpaRepository<Attendence_otp, Long>{
	
	

}
