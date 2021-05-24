package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.hibernate.SQLQuery;

//import org.hibernate.query.Query;

//import org.hibernate.Query;

//import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
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
import com.example.demo.model.Market;
import com.example.demo.repository.MarketRepository;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class MarketController {
	
	@Autowired
	private MarketRepository marketRepository;
	
	// get all products REST API
	@GetMapping("/market")
	public List<Market> getAllMarket() {
		return marketRepository.findAll();
	}
	
	// create products REST API
	@PostMapping("/market")
	public Market createMarket(@RequestBody Market market) {
		return marketRepository.save(market);
	}
	
	// get products by id REST API
	@GetMapping("/market/{id}")
	public ResponseEntity<Market> getMarketById(@PathVariable int id) {
		Market market = marketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Market with id " + id + "does not exist"));
		return ResponseEntity.ok(market);
	}
	
	// get products by customer id REST API
	@GetMapping("/market/customer/{customerId}")
	public ResponseEntity<List<Market>> getMarketBycustomerId(@PathVariable int customerId) {
		List<Market> market = marketRepository.findByCustomerId(customerId);
		return ResponseEntity.ok(market);
		}

	
	// update products REST API
	@PutMapping("/market/{id}")
	public ResponseEntity<Market> updateMarket(@PathVariable int id, @RequestBody Market marketDetails) {
		Market market = marketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Market with id " + id + "does not exist"));
		
		market.setProductPicture(marketDetails.getProductPicture());
		market.setProductname(marketDetails.getProductname());
		market.setDescription(marketDetails.getDescription());
		market.setPrice(marketDetails.getPrice());
		market.setUse(marketDetails.getUse());
		market.setFunctions(marketDetails.getFunctions());
		market.setQuality(marketDetails.getQuality());
		market.setQuantity(marketDetails.getQuantity());
		Market updatedMarket = marketRepository.save(market);
		return ResponseEntity.ok(updatedMarket);
	}
	
	// delete products REST API
	@DeleteMapping("/market/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMarket(@PathVariable int id) {
		Market market = marketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Market with id " + id + "does not exist"));
		
		marketRepository.delete(market);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	

}