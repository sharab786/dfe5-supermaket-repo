package com.qa.supermarket.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.supermarket.datamodel.Product;

// Create an interface to the JpaRepsoitory 
// (to the product class and the primary key is type Integer )
// This will give us access to the basic CRUD operations
// create, delete , insert and update.

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	
}
