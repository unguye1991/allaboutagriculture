package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Customer;
import com.example.demo.model.ShopingCart;

@Repository
public interface ShopingCartRepository extends JpaRepository<ShopingCart, Integer> {
	public List<ShopingCart> findByCustomer(Customer customer);
	public List<ShopingCart> findByCustomerId(int id);

}