package com.centene.healthcaretracker.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "dependent")
public class Dependent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private String name; 
	@JsonFormat(pattern="MM/dd/YYYY")
	private Date dob;
	
	@ManyToOne
	@JoinColumn(name = "enrollee_id")
	@JsonBackReference
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((enrollee == null) ? 0 : enrollee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dependent other = (Dependent) obj;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (enrollee == null) {
			if (other.enrollee != null)
				return false;
		} else if (!enrollee.equals(other.enrollee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dependent [id=" + id + ", name=" + name + ", dob=" + dob + ", enrollee=" + enrollee + "]";
	}
	
	
}
