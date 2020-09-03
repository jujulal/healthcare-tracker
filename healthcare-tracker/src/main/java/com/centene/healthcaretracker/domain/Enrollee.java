package com.centene.healthcaretracker.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "enrollee")
public class Enrollee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	private String name; 
	private boolean status; 
	@JsonFormat(pattern="MM/dd/YYYY")
	private Date dob; 
	private String phone; 
	
	@OneToMany(mappedBy = "enrollee", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Dependent> dependents;

	
	public Enrollee() {
		super();
	}

	public Enrollee(Long id, String name, boolean status, Date dob, String phone, List<Dependent> dependents) {
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

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dependents == null) ? 0 : dependents.hashCode());
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		Enrollee other = (Enrollee) obj;
		if (dependents == null) {
			if (other.dependents != null)
				return false;
		} else if (!dependents.equals(other.dependents))
			return false;
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
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
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enrollee [id=" + id + ", name=" + name + ", status=" + status + ", dob=" + dob + ", phone=" + phone
				+ ", dependents=" + dependents + "]";
	}
	
	
}
