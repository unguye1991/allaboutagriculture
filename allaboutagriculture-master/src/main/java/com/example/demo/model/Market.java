package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "market")

public class Market {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@Column(name = "product_picture")
	private String ProductPicture;
	
	@Column(name = "product_name")
	private String productname;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "the_use")
	private String use;
	
	@Column(name = "functions")
	private String functions;
	
	@Column(name = "quality")
	private String quality;
	
	@Column(name = "quantity")
	private int quantity;
	
	
	public Market() {
		
	}
	public Market(Customer customer, String ProductPicture, String productname, String description, float price, String use,
			String functions, String quality, int quantity) {
		super();
		this.customer = customer;
		this.ProductPicture = ProductPicture;
		this.productname = productname;
		this.description = description;
		this.price = price;
		this.use = use;
		this.functions = functions;
		this.quality = quality;
		this.quantity = quantity;
	}
	

	public String getProductPicture() {
		return ProductPicture;
	}
	public void setProductPicture(String productPicture) {
		ProductPicture = productPicture;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getFunctions() {
		return functions;
	}
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}