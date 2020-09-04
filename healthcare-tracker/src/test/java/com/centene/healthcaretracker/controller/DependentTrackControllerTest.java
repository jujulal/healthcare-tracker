package com.centene.healthcaretracker.controller;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.centene.healthcaretracker.domain.Dependent;
import com.centene.healthcaretracker.service.DependentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DependentTrackControllerTest {

	private Logger log = LoggerFactory.getLogger(DependentTrackControllerTest.class);
	
	@Autowired
	MockMvc mockMvc;
	@Autowired
	DependentService dependentService;
	
	@Test
	public void getAllDependentTest() throws Exception {
		mockMvc.perform(get("/getAllDependent").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void addDependentTest() throws Exception {
		//creating Dependent obj
		Dependent dependent = new Dependent(null, "Jim Baa", Date.valueOf("1970-05-15"), null);
		mockMvc
		.perform(post("/addDependent").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(dependent)).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andReturn();
		
		//making sure record exist at db 
		List<Dependent> dependents = dependentService.findByName("Jim Baa");
		assertTrue(dependents.size()>0);
		assertTrue(dependents.get(0).getName().contentEquals("Jim Baa"));
	}
	
	static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
