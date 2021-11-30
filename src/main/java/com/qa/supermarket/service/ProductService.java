package com.qa.supermarket.service;

import java.util.List;
import java.util.Optional;

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
	
	// Method to update a product
	public Product updateProduct(Product product, Integer id) {
		// find the product to update
		Optional<Product> productToFind = this.repo.findById(id);
		Product productToUpdate = productToFind.get();
		// set that product with the new values
		productToUpdate.setName(product.getName());
		productToUpdate.setCategory(product.getCategory());
		productToUpdate.setPrice(product.getPrice());
		productToUpdate.setColour(product.getColour());
		productToUpdate.setQuantity(product.getQuantity());
		productToUpdate.setActiveForSale(product.isActiveForSale());	
		// save updated product
		return this.repo.save(productToUpdate);
	}
	
	public boolean deleteProduct(Integer id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
}
