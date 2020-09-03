package com.centene.healthcaretracker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centene.healthcaretracker.domain.Enrollee;
import com.centene.healthcaretracker.repository.DependentRepository;
import com.centene.healthcaretracker.repository.EnrolleeRepository;
import com.centene.healthcaretracker.service.EnrolleeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class EnrolleeTrackController {

	@Autowired
	EnrolleeService enrolleeService;
	
	@PostMapping("/addEnrollee")
	public @ResponseBody Enrollee addEnrollee(@RequestBody Enrollee enrollee) {
		
		return enrolleeService.addEnrollee(enrollee);
	}
	@PostMapping("/updateEnrollee")
	public Enrollee updateEnrollee(@RequestBody Enrollee enrollee) {
		return enrolleeService.updateEnrollee(enrollee);
	}
	
	@GetMapping("/getAllEnrollee")
	public List<Enrollee> getAllEnrollee(){
		
		return enrolleeService.getAllEnrollee();
	}
	
	@GetMapping("/getEnrollee/{id}")
	public Optional<Enrollee> getEnrollee(@PathVariable("id") Long id){
		
		return enrolleeService.getEnrollee(id);
	}
	
	@DeleteMapping("/removeEnrollee/{id}")
	public void removeEnrollee(@PathVariable("id") Long id) {
		
		enrolleeService.removeEnrollee(id);
	}
}
