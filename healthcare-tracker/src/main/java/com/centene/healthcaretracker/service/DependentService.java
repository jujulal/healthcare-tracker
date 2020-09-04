package com.centene.healthcaretracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centene.healthcaretracker.domain.Dependent;
import com.centene.healthcaretracker.repository.DependentRepository;

@Service
public class DependentService {
	
	@Autowired
	private DependentRepository dependentRepository; 
	
	public Dependent addDependent(Dependent dependent) {
		
		return dependentRepository.save(dependent);
	}
	
	public List<Dependent> getAllDependent(){
		return dependentRepository.findAll();
	}
	
	public Optional<Dependent> getDependent(Long id) {
		return dependentRepository.findById(id);
	}
	
	public Dependent updateDependent(Dependent dependent) {
		return dependentRepository.save(dependent);
	}
	
	public void removeDependent(Long id) {
		dependentRepository.deleteById(id);
	}
	public List<Dependent> findByName(String name){
		return dependentRepository.findByName(name);
	}
}
