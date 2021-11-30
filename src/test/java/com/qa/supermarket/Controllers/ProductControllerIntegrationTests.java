package com.qa.supermarket.Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.supermarket.datamodel.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:test-schema.sql", "classpath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class ProductControllerIntegrationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;

	// Test the Post -create API 
	@Test
	void createProductTest() throws Exception {
		String testProductAsJson = this.mapper.writeValueAsString(new Product(null, "Big Hoodie", "Sportswear", 49.99, "blue", 495, true));
		String testProductAsJsonResponse = this.mapper.writeValueAsString(new Product(6, "Big Hoodie", "Sportswear", 49.99, "blue", 495, true));
		
		RequestBuilder request = post("/product/create").contentType(MediaType.APPLICATION_JSON).content(testProductAsJson);
		
		ResultMatcher status = status().isCreated();
		ResultMatcher content = content().json(testProductAsJsonResponse);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}

}
