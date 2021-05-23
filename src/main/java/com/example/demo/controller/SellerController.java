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
import com.example.demo.model.Seller;
import com.example.demo.repository.SellerRepository;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class SellerController {
	
	@Autowired
	private SellerRepository SellerRepository;
		
	// get all users REST API
	@GetMapping("/sellers")
	public List<Seller> getAllSellers() {
		return SellerRepository.findAll();
	}
	
	// create user REST API
	@PostMapping("/sellers")
	public Seller createSeller(@RequestBody Seller seller) {
		return SellerRepository.save(seller);
	}
	
	// get user by id REST API
	@GetMapping("/sellers/{id}")
	public ResponseEntity<Seller> getSellerById(@PathVariable int id) {
		Seller seller = SellerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Seller with id " + id + "does not exist"));
		return ResponseEntity.ok(seller);
	}
	
	// get user by email REST API
	@GetMapping("/sellers/email/{email}")
	public ResponseEntity<Seller> getSellerByEmail(@PathVariable String email) {
		Seller seller = SellerRepository.findByEmail(email);
//				.orElseThrow(() -> new ResourceNotFoundException("User with email " + email + "does not exist"));
		return ResponseEntity.ok(seller);
	}
	
	// get user by email REST API
	@GetMapping("/sellers/emails/{email}")
	public ResponseEntity<List<Seller>> getSellersByEmail(@PathVariable String email) {
		List<Seller> seller = SellerRepository.findAllByEmail(email);
//				.orElseThrow(() -> new ResourceNotFoundException("User with email " + email + "does not exist"));
		return ResponseEntity.ok(seller);
	}
	
	// update user REST API
	@PutMapping("/sellers/{id}")
	public ResponseEntity<Seller> updateSeller(@PathVariable int id, @RequestBody Seller sellerDetails) {
		Seller seller = SellerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Seller with id " + id + "does not exist"));
		
		seller.setProfilePicLink(sellerDetails.getProfilePicLink());
		seller.setNickname(sellerDetails.getNickname());
		seller.setPassword(sellerDetails.getPassword());
		seller.setContactDetail(sellerDetails.getContactDetail());
		seller.setPhone(sellerDetails.getPhone());
		seller.setEmail(sellerDetails.getEmail());
		seller.setAddress(sellerDetails.getAddress());
		seller.setCertification(sellerDetails.getCertification());
		seller.setEwallet(sellerDetails.getEwallet());
		
		Seller updatedSeller = SellerRepository.save(seller);
		return ResponseEntity.ok(updatedSeller);
	}
	
	// delete user REST API
	@DeleteMapping("/sellers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSeller(@PathVariable int id) {
		Seller seller = SellerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Seller with id " + id + "does not exist"));
		
		SellerRepository.delete(seller);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
