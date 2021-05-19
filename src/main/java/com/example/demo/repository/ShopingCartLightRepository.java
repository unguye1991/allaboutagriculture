package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ShopingCartLight;
import com.example.demo.model.ShopingCart;

@Repository
public interface ShopingCartLightRepository extends JpaRepository<ShopingCartLight, Integer> {
	
	public List<ShopingCartLight> findByShopingCart(ShopingCart shopingcart);
	public List<ShopingCartLight> findByShopingCartId(int id);

}
