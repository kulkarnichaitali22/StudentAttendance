package com.StudentAttendence.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudentAttendence.Entity.Faculty;
import com.StudentAttendence.Entity.Student;
import com.StudentAttendence.service.FacultyService;

@RestController
@RequestMapping("Faculty")
public class FacultyController{
	
	@Autowired
	private FacultyService facultyService;
	
	
	@PostMapping("loginFaculty/{id}/{username}/{password}")
	public String loginFaculty(@PathVariable long id,@PathVariable String username,@PathVariable int password)
	{
		return facultyService.loginFaculty(id, username, password);
	}
	
	@GetMapping("/getStudent/{id}")
	public Optional<Student> getStudent(@PathVariable long id) {
		return facultyService.getStudent(id);
	}
	
	@GetMapping("getFaculty/{id}")
	public Optional<Faculty> getFaculty(@PathVariable("id") long id)
	{
		return facultyService.getFaculty(id);
	}

	@PostMapping("/saveFaculty")
	public Faculty saveFaculty(@RequestBody Faculty faculty) {
		return facultyService.saveFaculty(faculty);
	}
	
	@PostMapping("/saveStudent")
	public String saveStudent(@RequestBody Student std) {
		return facultyService.saveStudent(std);
	}

	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable long id, @RequestBody Student std) {
		
		return facultyService.updateStudent(id, std);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable long id)
	{
		
		return facultyService.deleteStudent(id);
		
	}
	
	@PostMapping("/sendEmail/{to}/{subject}/{body}")
    public String sendEmail(@PathVariable String to,@PathVariable String subject,@PathVariable String body) {
                
        facultyService.sendEmail(to, subject, body);
        return "Email sent successfully to " + to;
    }
	
	

}
