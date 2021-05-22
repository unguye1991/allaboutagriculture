package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopingcartlight")
public class ShopingCartLight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "shopingcart_id")
	private ShopingCart shopingcart;
	
	@Column(name = "product_name")
	private String productname;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "quantity")
	private int quantity;
	
public ShopingCartLight() {
		
	}
	public ShopingCartLight(ShopingCart shopingcart , String productname, float price, int quantity) {
		// super();
		this.shopingcart = shopingcart;
		this.productname = productname;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ShopingCart getShopingcart() {
		return shopingcart;
	}
	public void setShopingcart(ShopingCart shopingcart) {
		this.shopingcart = shopingcart;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
