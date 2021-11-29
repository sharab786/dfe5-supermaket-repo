package com.qa.supermarket.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// This entity represents the product table in the database.
// Each entity instance corresponds to a row in the table



@Entity
public class Product {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; // this is the primary key in the database and so it is auto-generated. 
	private String name;
	private String category;
	private double price;
	private String colour;
	private int quantity;
	private boolean activeForSale;
	
	// This is a no-arg constructor - it takes no parameters
	public Product() {
	}
	
	// Constructor with parameters
	public Product(Integer id, String name, String category, double price, String colour, int quantity,
			boolean activeForSale) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.colour = colour;
		this.quantity = quantity;
		this.activeForSale = activeForSale;
	}
	
	// Setters and Getters 

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActiveForSale() {
		return activeForSale;
	}

	public void setActiveForSale(boolean activeForSale) {
		this.activeForSale = activeForSale;
	}
	


}
