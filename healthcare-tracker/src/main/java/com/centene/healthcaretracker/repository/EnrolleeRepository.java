package com.centene.healthcaretracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.centene.healthcaretracker.domain.Enrollee;

public interface EnrolleeRepository extends JpaRepository <Enrollee, Long>{
	
	Enrollee findByName(String name);
}
