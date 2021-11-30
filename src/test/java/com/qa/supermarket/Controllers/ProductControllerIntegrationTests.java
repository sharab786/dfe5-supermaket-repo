package com.qa.supermarket.Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class ProductControllerIntegrationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	// Test the Post -create API
	@Test
	void createProductTest() throws Exception {
		String testProductAsJson = this.mapper
				.writeValueAsString(new Product(null, "Big Hoodie", "Sportswear", 49.99, "blue", 495, true));
		String testProductAsJsonResponse = this.mapper
				.writeValueAsString(new Product(6, "Big Hoodie", "Sportswear", 49.99, "blue", 495, true));

		RequestBuilder request = post("/product/create").contentType(MediaType.APPLICATION_JSON)
				.content(testProductAsJson);

		ResultMatcher status = status().isCreated();
		ResultMatcher content = content().json(testProductAsJsonResponse);

		this.mvc.perform(request).andExpect(status).andExpect(content);
	}

	// Test the get all API
	@Test
	void getAllProductsTest() throws Exception {
		String listOfProductssAsJSON = this.mapper.writeValueAsString(
				List.of(new Product(1, "Awesome Fresh Shoes", "Footwear", 59.99, "black", 495, true),
						new Product(2, "Sausage Multi", "Dresses", 50.50, "orange", 100, false),
						new Product(3, "Superstar Trainers", "Footwear", 179.50, "white", 24, true),
						new Product(4, "Rustic Soft", "Coats", 90.00, "turquoise", 252, true),
						new Product(5, "Awesome Fresh Joggers", "Sportswear", 29.99, "black", 495, false)));

		RequestBuilder request = get("/product");

		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(listOfProductssAsJSON);

		this.mvc.perform(request).andExpect(status).andExpect(content);

	}
	
	// Test the update API
	@Test
	void updateProductTest() throws Exception{
		String testProductAsJsonResponse = this.mapper.writeValueAsString(new Product(2, "Sausage Multi", "Dresses", 50.50, "red", 50, false));
		
		RequestBuilder request = put("/product/update/2").contentType(MediaType.APPLICATION_JSON).content(testProductAsJsonResponse);

		ResultMatcher status = status().isAccepted();
		ResultMatcher content = content().json(testProductAsJsonResponse);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
	}
	 
	
	// This is the delete API test
	@Test
	void deleteProductTest() throws Exception{
			
	this.mvc.perform(delete("/product/delete/2")).andExpect(status().isOk());
	}
	
	
	@Test
	void getProductsByPriceGreaterTest() throws Exception{
		
		String listOfProductssAsJSON = this.mapper.writeValueAsString(
				List.of(new Product(3, "Superstar Trainers", "Footwear", 179.50, "white", 24, true),
						new Product(4, "Rustic Soft", "Coats", 90.00, "turquoise", 252, true)
						));

		
		RequestBuilder request = get("/product/60.50");
		
		ResultMatcher status = status().isOk();
		ResultMatcher content = content().json(listOfProductssAsJSON);
		
		this.mvc.perform(request).andExpect(status).andExpect(content);
		
	}
}
