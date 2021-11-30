package com.qa.supermarket.service;

import java.util.List;

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

	
	// Method to get all products that exist
	public List<Product> getAllProducts() {
		// SELECT * FROM book;
		return this.repo.findAll();
	}
}
