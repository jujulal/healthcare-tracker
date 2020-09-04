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

import com.centene.healthcaretracker.domain.Enrollee;
import com.centene.healthcaretracker.service.EnrolleeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class EnrolleeTrackController {
	
	private Logger log = LoggerFactory.getLogger(EnrolleeTrackController.class);

	@Autowired
	EnrolleeService enrolleeService;
	
	@PostMapping("/addEnrollee")
	public @ResponseBody Enrollee addEnrollee(@RequestBody Enrollee enrollee) {
		log.info("Request for add Enrolle received!");
		return enrolleeService.addEnrollee(enrollee);
	}
	@PostMapping("/updateEnrollee")
	public Enrollee updateEnrollee(@RequestBody Enrollee enrollee) {
		log.info("Request for update Enrolle received!");
		return enrolleeService.updateEnrollee(enrollee);
	}
	
	@GetMapping("/getAllEnrollee")
	public List<Enrollee> getAllEnrollee(){
		log.info("Request for get all Enrolle received!");
		return enrolleeService.getAllEnrollee();
	}
	
	@GetMapping("/getEnrollee/{id}")
	public Optional<Enrollee> getEnrollee(@PathVariable("id") Long id){
		
		return enrolleeService.getEnrollee(id);
	}
	
	@DeleteMapping("/removeEnrollee/{id}")
	public void removeEnrollee(@PathVariable("id") Long id) {
		log.info("Remove request for Enrolle with {} received!", id);
		enrolleeService.removeEnrollee(id);
	}
}
