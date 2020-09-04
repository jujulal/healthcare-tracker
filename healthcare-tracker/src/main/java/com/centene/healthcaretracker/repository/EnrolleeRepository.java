package com.centene.healthcaretracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.centene.healthcaretracker.domain.Enrollee;
@Repository
public interface EnrolleeRepository extends JpaRepository <Enrollee, Long>{
	
	Enrollee findByName(String name);
}
