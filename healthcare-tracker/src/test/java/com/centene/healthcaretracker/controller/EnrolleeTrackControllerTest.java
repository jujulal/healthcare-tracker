package com.centene.healthcaretracker.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.centene.healthcaretracker.domain.Dependent;
import com.centene.healthcaretracker.domain.Enrollee;

import com.centene.healthcaretracker.service.DependentService;
import com.centene.healthcaretracker.service.EnrolleeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest//(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class EnrolleeTrackControllerTest {

	@Autowired
	EnrolleeService enrolleeService;
	@Autowired
	DependentService dependentService;
	@Autowired
	MockMvc mockMvc;
	
	Dependent mockDependent;
	Enrollee mockEnrollee;

	@Before
	public void setup() {

		try {
			Date dob = Date.valueOf("2015-12-01");
			mockDependent = new Dependent(9L, "Aanya Shrestha", dob, null);
			List<Dependent> dependents = new ArrayList();
			dependents.add(mockDependent);

			mockEnrollee = new Enrollee(7L, "Bibek Shrestha", true, Date.valueOf("1980-05-15"), "234-354-9876",
					dependents);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void addEnrolleeTest() throws Exception {
		MvcResult result = mockMvc
				.perform(post("/addEnrollee").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(mockEnrollee)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
		//asserting value object return from service
		Enrollee enrollee = enrolleeService.findByName("Bibek Shrestha");
		assertNotNull(enrollee);
		assertTrue(enrollee.getName().contentEquals("Bibek Shrestha"));
		assertTrue(enrollee.getPhone().contentEquals("234-354-9876"));
		
	}

	@Test
	public void getEnrolleeTest() throws Exception {
		mockMvc.perform(get("/getAllEnrollee").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

	}
	
	@Test
	public void removeEnrolleeTest() throws Exception {
		//adding a record for delete
		Date dob = Date.valueOf("2015-12-01");
		Dependent depA = new Dependent(null, "Ram Goun", dob,null);
		List<Dependent> dependents = new ArrayList();
		dependents.add(depA);
		Enrollee enrollee = new Enrollee(null, "Father Don", true, Date.valueOf("1981-06-25"),"411-890-6789", dependents);
		mockMvc
				.perform(post("/addEnrollee").contentType(MediaType.APPLICATION_JSON)
						.content(asJsonString(enrollee)).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		//making sure record exist at db 
		Enrollee enrolleeDB = enrolleeService.findByName("Father Don");
		assertNotNull(enrollee);
		assertTrue(enrollee.getName().contentEquals("Father Don"));
		assertTrue(enrollee.getPhone().contentEquals("411-890-6789"));
		
		//deleting this record
		String url = "/removeEnrollee/{" + enrolleeDB.getId() + "}";
		mockMvc
				.perform(delete(url, enrolleeDB.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn();
		
		//making sure record exist at db 
			 enrolleeDB = enrolleeService.findByName("Father Don");
			assertNull(enrolleeDB);
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
