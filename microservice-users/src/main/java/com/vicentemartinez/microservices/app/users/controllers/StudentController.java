package com.vicentemartinez.microservices.app.users.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vicentemartinez.microservices.app.users.models.entity.Student;
import com.vicentemartinez.microservices.app.users.services.StudentService;
import com.vicentemartinez.microservices.commons.controllers.CommonController;

@RestController
public class StudentController extends CommonController<Student, StudentService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> saveStudent(@RequestBody Student student, @PathVariable Long id){
		Optional<Student> optionalStudent = service.findById(id);
		if(!optionalStudent.isPresent()) 
			return ResponseEntity.notFound().build();
		Student dbStudent = optionalStudent.get();
		dbStudent.setName(student.getName());
		dbStudent.setLastname(student.getLastname());
		dbStudent.setEmail(student.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dbStudent));
	}

}
