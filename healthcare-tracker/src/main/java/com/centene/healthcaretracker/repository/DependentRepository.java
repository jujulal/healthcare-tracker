package com.centene.healthcaretracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centene.healthcaretracker.domain.Dependent;
import com.centene.healthcaretracker.domain.Enrollee;

public interface DependentRepository extends JpaRepository<Dependent, Long>{
	
	List<Dependent> findByEnrollee(Enrollee enrollee);
}
