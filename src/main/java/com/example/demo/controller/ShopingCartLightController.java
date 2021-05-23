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
import com.example.demo.model.ShopingCartLight;
import com.example.demo.repository.ShopingCartLightRepository;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class ShopingCartLightController {
	
	@Autowired
	private ShopingCartLightRepository ShopingCartLightRepository;
	
	// get all ShopingCartLight REST API
	@GetMapping("/shopingcartlight")
	public List<ShopingCartLight> getAllShopingCartLight() {
		return ShopingCartLightRepository.findAll();
	}
	
	// create ShopingCartLight REST API
	@PostMapping("/shopingcartlight")
	public ShopingCartLight createShopingCartLight(@RequestBody ShopingCartLight shopingcartlight) {
		return ShopingCartLightRepository.save(shopingcartlight);
	}
	
	// get ShopingCartLight by id REST API
	@GetMapping("/shopingcartlight/{id}")
	public ResponseEntity<ShopingCartLight> getShopingCartLightById(@PathVariable int id) {
		ShopingCartLight shopingcartlight = ShopingCartLightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ShopingCartLight with id " + id + "does not exist"));
		return ResponseEntity.ok(shopingcartlight);
	}
	
	// update ShopingCartLight REST API
	@PutMapping("/shopingcartlight/{id}")
	public ResponseEntity<ShopingCartLight> updateShopingCartLight(@PathVariable int id, @RequestBody ShopingCartLight shopingcartlightDetails) {
		ShopingCartLight shopingcartlight = ShopingCartLightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ShopingCartLight with id " + id + "does not exist"));
		
		shopingcartlight.setProductname(shopingcartlightDetails.getProductname());
		shopingcartlight.setPrice(shopingcartlightDetails.getPrice());
		shopingcartlight.setQuantity(shopingcartlightDetails.getQuantity());
		
		ShopingCartLight updatedshopingcartlight = ShopingCartLightRepository.save(shopingcartlight);
		return ResponseEntity.ok(updatedshopingcartlight);
	}
	
	// get ShopingCartLight by ShopingCart id REST API
	@GetMapping("/shopingcartlight/shopingcart/{shopingcartId}")
	public ResponseEntity<List<ShopingCartLight>> getShopingCartLightByshopingcartId(@PathVariable int shopingcartId) {
		List<ShopingCartLight> shopingcartlight = ShopingCartLightRepository.findByShopingCartId(shopingcartId);
		return ResponseEntity.ok(shopingcartlight);
		}
	
	// delete ShopingCartLight REST API
	@DeleteMapping("/shopingcartlight/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteShopingCartLight(@PathVariable int id) {
		ShopingCartLight shopingcartlight = ShopingCartLightRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ShopingCartLight with id " + id + "does not exist"));
		
		ShopingCartLightRepository.delete(shopingcartlight);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
