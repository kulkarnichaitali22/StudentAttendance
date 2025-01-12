package com.StudentAttendence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.StudentAttendence.Entity.Attendence;
import com.StudentAttendence.Entity.Attendence_otp;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendence, Long> {


}
