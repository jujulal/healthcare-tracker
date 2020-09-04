package com.centene.healthcaretracker.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centene.healthcaretracker.domain.Dependent;
import com.centene.healthcaretracker.domain.Enrollee;
import com.centene.healthcaretracker.repository.DependentRepository;
import com.centene.healthcaretracker.repository.EnrolleeRepository;
import com.centene.healthcaretracker.service.DependentService;
import com.centene.healthcaretracker.service.EnrolleeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class DependentTrackController {

	private Logger log = LoggerFactory.getLogger(EnrolleeTrackController.class);
	
	@Autowired
	DependentService dependentService;
	
	@PostMapping("/addDependent")
	public @ResponseBody Dependent addDependent(@RequestBody Dependent dependent) {
		log.info("Request for add Dependent received!");
		return dependentService.addDependent(dependent);
	}
	@PostMapping("/updateDependent")
	public Dependent updateDependent(@RequestBody Dependent dependent) {
		log.info("Request for update Dependent received!");
		return dependentService.updateDependent(dependent);
	}
	
	@GetMapping("/getAllDependent")
	public List<Dependent> getAllDependent(){
		log.info("Request for get all Dependents received!");
		return dependentService.getAllDependent();
	}
	
	@GetMapping("/getDependent/{id}")
	public Optional<Dependent> getDependent(@PathVariable("id") Long id){
		log.info("Request for get Dependent received!");
		return dependentService.getDependent(id);
	}
	
	@DeleteMapping("/removeDependent/{id}")
	public void removeDependent(@PathVariable("id") Long id) {
		log.info("Remove request for Dependent with id {} received!", id);
		dependentService.removeDependent(id);
	}
}
