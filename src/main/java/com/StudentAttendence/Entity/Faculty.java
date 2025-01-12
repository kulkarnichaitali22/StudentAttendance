package com.StudentAttendence.Entity;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Faculty {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long facultyId;
	private String name;
	private String username;
	private int password;
	private Date createdDate;
	private Date modifiedDate;

	
	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty( String name, String username, int password, Date createdDate, Date modifiedDate) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	public long getId() {
		return facultyId;
	}

	public void setId(long facultyId) {
		this.facultyId = facultyId;
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

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
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
