package com.qa.supermarket.service;

import org.springframework.stereotype.Service;

import com.qa.supermarket.datamodel.Product;
import com.qa.supermarket.repo.ProductRepo;

// This is where the business logic will be contained 
@Service
public class ProductService {
	private ProductRepo repo;

// Constructor for the class which takes the repo as argument
	public ProductService(ProductRepo repo) {
		this.repo = repo;
	}
	
	
	
	// Method to create a new product createProduct
	
	public Product createProduct(Product product) {
		// Add the product and save
		return this.repo.save(product);
	}

}
