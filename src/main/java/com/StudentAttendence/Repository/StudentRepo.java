package com.StudentAttendence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import com.StudentAttendence.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	
	Optional<Student> findById(Long id);

}
