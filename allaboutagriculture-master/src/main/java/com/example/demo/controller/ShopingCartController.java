package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ShopingCart;
import com.example.demo.repository.ShopingCartRepository;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class ShopingCartController {
	
	@Autowired
	private ShopingCartRepository ShopingCartRepository;
	
	// get all ShopingCart REST API
	@GetMapping("/shopingcart")
	public List<ShopingCart> getAllShopingCart() {
		return ShopingCartRepository.findAll();
	}
	
	// create ShopingCart REST API
	@PostMapping("/shopingcart")
	public ShopingCart createShopingCart(@RequestBody ShopingCart shopingcart) {
		return ShopingCartRepository.save(shopingcart);
	}
	
	// get ShopingCart by id REST API
	@GetMapping("/shopingcart/{id}")
	public ResponseEntity<ShopingCart> getShopingCartById(@PathVariable int id) {
		ShopingCart shopingcart = ShopingCartRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ShopingCart with id " + id + "does not exist"));
		return ResponseEntity.ok(shopingcart);
	}
	
	// update ShopingCart REST API
	@PutMapping("/shopingcart/{id}")
	public ResponseEntity<ShopingCart> updateShopingCart(@PathVariable int id, @RequestBody ShopingCart shopingcartDetails) {
		ShopingCart shopingcart = ShopingCartRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ShopingCart with id " + id + "does not exist"));
		
		shopingcart.setProductPicture(shopingcartDetails.getProductPicture());
		shopingcart.setProductname(shopingcartDetails.getProductname());
		shopingcart.setDescription(shopingcartDetails.getDescription());
		shopingcart.setPrice(shopingcartDetails.getPrice());
		shopingcart.setUse(shopingcartDetails.getUse());
		shopingcart.setFunctions(shopingcartDetails.getFunctions());
		shopingcart.setQuality(shopingcartDetails.getQuality());
		shopingcart.setQuantity(shopingcartDetails.getQuantity());
		
		ShopingCart updatedshopingcart = ShopingCartRepository.save(shopingcart);
		return ResponseEntity.ok(updatedshopingcart);
	}
	
	// get products by customer id REST API
	@GetMapping("/shopingcart/seller/{sellerId}")
	public ResponseEntity<List<ShopingCart>> getShopingCartBycustomerId(@PathVariable int customerId) {
		List<ShopingCart> shopingcart = ShopingCartRepository.findByCustomerId(customerId);
		return ResponseEntity.ok(shopingcart);
		}
	
	// delete ShopingCart REST API
	@DeleteMapping("/shopingcart/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteShopingCart(@PathVariable int id) {
		ShopingCart shopingcart = ShopingCartRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ShopingCart with id " + id + "does not exist"));
		
		ShopingCartRepository.delete(shopingcart);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	
	
}