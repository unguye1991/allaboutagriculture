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
import com.example.demo.model.Courses;
import com.example.demo.repository.CoursesRepository;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class CoursesController {
	
	@Autowired
	private CoursesRepository CoursesRepository;
	
	// get all programs REST API
	@GetMapping("/courses")
	public List<Courses> getAllCourses() {
		return CoursesRepository.findAll();
	}
	
	// create program REST API
	@PostMapping("/courses")
	public Courses createCourses(@RequestBody Courses courses) {
		return CoursesRepository.save(courses);
	}
	
	// get program by id REST API
	@GetMapping("/courses/{id}")
	public ResponseEntity<Courses> getCourseById(@PathVariable int id) {
		Courses courses = CoursesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Courses with id " + id + "does not exist"));
		return ResponseEntity.ok(courses);
	}
	
	// get courses by school id REST API
	@GetMapping("/courses/customer/{customerId}")
	public ResponseEntity<List<Courses>> getCoursesBycustomerid(@PathVariable int customerId) {
		List<Courses> courses = CoursesRepository.findByCustomerId(customerId);
		return ResponseEntity.ok(courses);
	}

	// update program REST API
	@PutMapping("courses/{id}")
	public ResponseEntity<Courses> updateCourses(@PathVariable int id, @RequestBody Courses coursesDetails) {
		Courses courses = CoursesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Courses with id " + id + "does not exist"));
		
		courses.setCoursename(coursesDetails.getCoursename());
		courses.setContact(coursesDetails.getContact());
		courses.setDescription(coursesDetails.getDescription());
		Courses updatedCourses = CoursesRepository.save(courses);
		return ResponseEntity.ok(updatedCourses);
	}
	
	// delete program REST API
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCourses(@PathVariable int id) {
		Courses courses = CoursesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Courses with id " + id + "does not exist"));
		
		CoursesRepository.delete(courses);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
