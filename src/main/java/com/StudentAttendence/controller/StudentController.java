package com.StudentAttendence.controller;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAttendence.Entity.Student;
import com.StudentAttendence.service.StudentService;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/loginStudent/{id}/{username}/{password}")
	public String loginStudent(@PathVariable long id,@PathVariable String username,@PathVariable String password )
	{
		return studentService.loginStudent(id, username, password);
	}
	
	@GetMapping("/getStudentById/{id}")
	public Optional<Student> getStudent(@PathVariable long id)
	{
		return studentService.getStudent(id);
	}
	
	
}
