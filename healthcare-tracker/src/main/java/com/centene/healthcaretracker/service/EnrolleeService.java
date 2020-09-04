package com.centene.healthcaretracker.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centene.healthcaretracker.domain.Enrollee;
import com.centene.healthcaretracker.repository.EnrolleeRepository;

@Service
public class EnrolleeService {
	
	private Logger log = LoggerFactory.getLogger(EnrolleeService.class);
	
	@Autowired
	private EnrolleeRepository enrolleeRepository;
	
	public Enrollee addEnrollee(Enrollee enrollee) {
		log.info("EnrolleeService added new Enrollee!");
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
	
	public Enrollee findByName(String name) {
		return enrolleeRepository.findByName(name);
	}
}
