package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Courses;
import com.example.demo.model.Seller;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
	public List<Courses> findBySeller(Seller seller);
	public List<Courses> findBySellerId(int id);

}
