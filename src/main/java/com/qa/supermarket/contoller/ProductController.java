package com.qa.supermarket.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.supermarket.service.ProductService;

//  Controllers Map to Requests
@RestController     // This will make this class a rest controller
@RequestMapping(path="/product")  // This designates a base path /product that all methods in the class will start with
public class ProductController {
	
	private ProductService service;

	// Constructor with the service as parameter to which it uses.
	public ProductController(ProductService service) {
		this.service = service;
	} 
	
	// Mapping annotations below for different methods we would want to respond to the request.
	
	

}
