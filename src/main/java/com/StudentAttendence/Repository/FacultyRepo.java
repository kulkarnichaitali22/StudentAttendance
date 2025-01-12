package com.StudentAttendence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentAttendence.Entity.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long>{
	
	Optional<Faculty> findById(Long id);
}
