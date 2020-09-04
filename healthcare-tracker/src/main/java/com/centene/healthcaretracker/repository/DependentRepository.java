package com.centene.healthcaretracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centene.healthcaretracker.domain.Dependent;
import com.centene.healthcaretracker.domain.Enrollee;
@Repository
public interface DependentRepository extends JpaRepository<Dependent, Long>{
	
	List<Dependent> findByEnrollee(Enrollee enrollee);
	List<Dependent> findByName(String name);
}
