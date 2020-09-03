package com.centene.healthcaretracker.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.centene.healthcaretracker.domain.Dependent;
import com.centene.healthcaretracker.domain.Enrollee;

public interface DependentRepository extends CrudRepository<Dependent, Long>{
	
	List<Dependent> findByEnrollee(Enrollee enrollee);
}
