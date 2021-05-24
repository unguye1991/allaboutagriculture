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
import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;


@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class CommentController {
	
	@Autowired
	private CommentRepository CommentRepository;
	
	// get all comment REST API
	@GetMapping("/comment")
	public List<Comment> getAllComment() {
		return CommentRepository.findAll();
	}
	
	// create comment REST API
	@PostMapping("/comment")
	public Comment createComment(@RequestBody Comment comment) {
		return CommentRepository.save(comment);
	}
	
	// get comment by id REST API
	@GetMapping("/comment/{id}")
	public ResponseEntity<Comment> getCommentById(@PathVariable int id) {
		Comment comment = CommentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + "does not exist"));
		return ResponseEntity.ok(comment);
	}
	
	// get comment by forum id REST API
	@GetMapping("/comment/forum/{forumId}")
	public ResponseEntity<List<Comment>> getCommentByForumId(@PathVariable int ForumId) {
		List<Comment> comment = CommentRepository.findByForumId(ForumId);
		return ResponseEntity.ok(comment);
	}

	// update comment REST API
	@PutMapping("comment/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable int id, @RequestBody Comment commentDetails) {
		Comment comment = CommentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + "does not exist"));
		
		comment.setComment(commentDetails.getComment());
		
		Comment updatedComment = CommentRepository.save(comment);
		return ResponseEntity.ok(updatedComment);
	}
	
	// delete comment REST API
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<Map<String, Boolean>> deletecomment(@PathVariable int id) {
		Comment comment = CommentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + "does not exist"));
		
		CommentRepository.delete(comment);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}