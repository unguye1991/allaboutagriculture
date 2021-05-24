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
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;



@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class CustomerController {
	
	@Autowired
	private CustomerRepository CustomerRepository;
		
	// get all users REST API
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return CustomerRepository.findAll();
	}
	
	// create user REST API
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
		return CustomerRepository.save(customer);
	}
	
	// get user by id REST API
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
		Customer customer = CustomerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + "does not exist"));
		return ResponseEntity.ok(customer);
	}
	
	// get user by email REST API
	@GetMapping("/customers/email/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
		Customer customer = CustomerRepository.findByEmail(email);
//				.orElseThrow(() -> new ResourceNotFoundException("Customer with email " + email + "does not exist"));
		return ResponseEntity.ok(customer);
	}
	
	// get user by email REST API
	@GetMapping("/customers/emails/{email}")
	public ResponseEntity<List<Customer>> getCustomersByEmail(@PathVariable String email) {
		List<Customer> customer = CustomerRepository.findAllByEmail(email);
//				.orElseThrow(() -> new ResourceNotFoundException("Customer with email " + email + "does not exist"));
		return ResponseEntity.ok(customer);
	}
	
	// update user REST API
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
		Customer customer = CustomerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + "does not exist"));
		
		customer.setProfilePicLink(customerDetails.getProfilePicLink());
		customer.setNickname(customerDetails.getNickname());
		customer.setPassword(customerDetails.getPassword());
		customer.setContactDetail(customerDetails.getContactDetail());
		customer.setPhone(customerDetails.getPhone());
		customer.setEmail(customerDetails.getEmail());
		customer.setAddress(customerDetails.getAddress());
		customer.setCertification(customerDetails.getCertification());
		customer.setEwallet(customerDetails.getEwallet());
		
		Customer updatedCustomer = CustomerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
	// delete user REST API
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable int id) {
		Customer customer = CustomerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with id " + id + "does not exist"));
		
		CustomerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}