package com.centene.healthcaretracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.centene.healthcaretracker.domain.Enrollee;
import com.centene.healthcaretracker.service.DependentRepository;
import com.centene.healthcaretracker.service.EnrolleeRepository;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@RestController
public class EnrolleeTrackController {

	@Autowired
	DependentRepository dependentRepository;
	@Autowired
	EnrolleeRepository enrolleeRepository;
	
	@PostMapping("/addEnrollee")
	public @ResponseBody Enrollee addEnrollee(@RequestBody Enrollee enrollee) {
		
		return enrolleeRepository.save(enrollee);
	}
}
