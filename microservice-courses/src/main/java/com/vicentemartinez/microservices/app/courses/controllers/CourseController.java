package com.vicentemartinez.microservices.app.courses.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vicentemartinez.microservices.app.courses.models.entity.Course;
import com.vicentemartinez.microservices.app.courses.services.CourseService;
import com.vicentemartinez.microservices.commons.controllers.CommonController;

@RestController
public class CourseController extends CommonController<Course, CourseService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> saveCourse(@RequestBody Course course, @PathVariable Long id){
		Optional<Course> optionalCourse = service.findById(id);
		if(!optionalCourse.isPresent()) 
			return ResponseEntity.notFound().build();
		Course dbCourse = optionalCourse.get();
		dbCourse.setName(course.getName());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbCourse));
	}

}
