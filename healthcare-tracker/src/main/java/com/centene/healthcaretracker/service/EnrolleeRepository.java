package com.centene.healthcaretracker.service;

import org.springframework.data.repository.CrudRepository;

import com.centene.healthcaretracker.domain.Enrollee;

public interface EnrolleeRepository extends CrudRepository <Enrollee, Long>{
	
	Enrollee findByName(String name);
}
