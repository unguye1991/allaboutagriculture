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
import com.example.demo.model.Forum;
import com.example.demo.repository.ForumRepository;


@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class ForumController {
	
	@Autowired
	private ForumRepository ForumRepository;
	
	// get all forum REST API
	@GetMapping("/forum")
	public List<Forum> getAllForum() {
		return ForumRepository.findAll();
	}
	
	// create forum REST API
	@PostMapping("/forum")
	public Forum createForum(@RequestBody Forum forum) {
		return ForumRepository.save(forum);
	}
	
	// get forum by id REST API
	@GetMapping("/forum/{id}")
	public ResponseEntity<Forum> getForumById(@PathVariable int id) {
		Forum forum = ForumRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Forum with id " + id + "does not exist"));
		return ResponseEntity.ok(forum);
	}
	
	// get forum by customer id REST API
	@GetMapping("/forum/customer/{customerId}")
	public ResponseEntity<List<Forum>> getForumBycustomerId(@PathVariable int customerId) {
		List<Forum> forum = ForumRepository.findByCustomerId(customerId);
		return ResponseEntity.ok(forum);
	}

	// update forum REST API
	@PutMapping("forum/{id}")
	public ResponseEntity<Forum> updateForum(@PathVariable int id, @RequestBody Forum forumDetails) {
		Forum forum = ForumRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Forum with id " + id + "does not exist"));
		
		forum.setTitle(forumDetails.getTitle());
		forum.setThumbnail(forumDetails.getThumbnail());
		forum.setDate(forumDetails.getDate());
		forum.setDescription(forumDetails.getDescription());
		Forum updatedForum = ForumRepository.save(forum);
		return ResponseEntity.ok(updatedForum);
	}
	
	// delete forum REST API
	@DeleteMapping("/forum/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteforum(@PathVariable int id) {
		Forum forum = ForumRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Forum with id " + id + "does not exist"));
		
		ForumRepository.delete(forum);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}