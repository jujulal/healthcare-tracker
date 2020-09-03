package com.centene.healthcaretracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centene.healthcaretracker.domain.Enrollee;
import com.centene.healthcaretracker.repository.EnrolleeRepository;

@Service
public class EnrolleeService {
	
	@Autowired
	private EnrolleeRepository enrolleeRepository;
	
	public Enrollee addEnrollee(Enrollee enrollee) {
		
		return enrolleeRepository.save(enrollee);
	}
	
	public List<Enrollee> getAllEnrollee(){
		
		return enrolleeRepository.findAll();
	}
	
	public Optional<Enrollee> getEnrollee(Long id){
		
		return enrolleeRepository.findById(id);
	}

	public Enrollee updateEnrollee(Enrollee enrollee) {
		
		return enrolleeRepository.save(enrollee);
	}
	
	public void removeEnrollee(Long id) {
		
		enrolleeRepository.deleteById(id);
	}
}
