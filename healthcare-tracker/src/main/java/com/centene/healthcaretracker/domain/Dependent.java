package com.centene.healthcaretracker.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dependent {
	@Id
	private Long id; 
	private String name; 
	private Date dob;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enrollee_id", nullable = false)
	private Enrollee enrollee;

	public Dependent() {
		super();
	}

	public Dependent(Long id, String name, Date dob, Enrollee enrollee) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.enrollee = enrollee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Enrollee getEnrollee() {
		return enrollee;
	}

	public void setEnrollee(Enrollee enrollee) {
		this.enrollee = enrollee;
	}
	
	
}
