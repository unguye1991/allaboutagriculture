package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;
import com.example.demo.model.Forum;
import com.example.demo.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	public List<Comment> findByCustomer(Customer customer);
	public List<Comment> findByCustomerId(int id);
	public List<Comment> findByForum(Forum forum);
	public List<Comment> findByForumId(int id);

}