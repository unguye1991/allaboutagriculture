package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Market;
import com.example.demo.model.Seller;

@Repository
public interface MarketRepository extends JpaRepository<Market, Integer> {
	
	public List<Market> findBySeller(Seller seller);
	public List<Market> findBySellerId(int id);

}
