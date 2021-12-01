package com.qa.supermarket.contoller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	// This is the mapping for get all products and the response
	 @GetMapping   
	    public ResponseEntity<List<Product>> get() {
	        ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(this.service.getAllProducts(), HttpStatus.OK); // 200       
	        return response;
	    }

	 // This is the mapping to update a product by id 
	 @PutMapping("/update/{id}")
	 public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Integer id) {
		 ResponseEntity<Product> response = new ResponseEntity<Product>(this.service.updateProduct(product, id), HttpStatus.ACCEPTED);
		 return response;
	 }
	 
	 // This is the mapping to delete a product by id
	 @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
	    	boolean deleted = this.service.deleteProduct(id);
	    			if(deleted) {
	    				return new ResponseEntity<>(HttpStatus.OK);
	    						}
	    			else {
	    				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    					}
	    }
	 
	 @GetMapping("/{price}")  
	    public ResponseEntity<List<Product>> findByPriceGreaterThan(@PathVariable double price) {
	        ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(this.service.findByPriceGreaterThan(price), HttpStatus.OK); // 200       
	        return response;
	 }
}
