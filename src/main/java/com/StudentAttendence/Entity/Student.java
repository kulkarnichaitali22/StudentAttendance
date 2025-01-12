package com.StudentAttendence.Entity;
import java.util.Date;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	
	private String name;
	private String username;
	private String password;
	private Date createdDate;
	private Date modifiedDate;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Student( String name, String username,String password, Date createdDate, Date modifiedDate) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public long getId() {
		return studentId;
	}

	public void setId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}


	

}
