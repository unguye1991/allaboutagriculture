package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Customer;
import com.example.demo.model.Forum;

@Repository
public interface ForumRepository extends JpaRepository<Forum, Integer> {
	
	public List<Forum> findByCustomer(Customer customer);
	public List<Forum> findByCustomerId(int id);

}