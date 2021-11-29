package com.qa.supermarket.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.qa.supermarket.datamodel.Product;
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
	
	
	
	// This is the mapping for creating new products and the response.
	@PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    	ResponseEntity<Product> response = new ResponseEntity<Product>(this.service.createProduct(product), HttpStatus.CREATED); // 201     
        return response;
    }
	
	

}
