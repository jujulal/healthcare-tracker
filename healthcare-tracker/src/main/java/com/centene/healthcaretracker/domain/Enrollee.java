package com.centene.healthcaretracker.domain;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Enrollee {
	@Id
	private Long id; 
	private String name; 
	private boolean status; 
	private Date dob; 
	private String phone; 
	
	@OneToMany(mappedBy = "enrollee", cascade = CascadeType.ALL)
	private Set<Dependent> dependents;

	
	public Enrollee() {
		super();
	}

	public Enrollee(Long id, String name, boolean status, Date dob, String phone, Set<Dependent> dependents) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.dob = dob;
		this.phone = phone;
		this.dependents = dependents;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(Set<Dependent> dependents) {
		this.dependents = dependents;
	}
	
	
}
