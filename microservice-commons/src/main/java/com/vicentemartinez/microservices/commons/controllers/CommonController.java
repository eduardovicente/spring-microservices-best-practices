package com.vicentemartinez.microservices.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vicentemartinez.microservices.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {
	
	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		Optional<E> optionalEntity = service.findById(id);
		if(!optionalEntity.isPresent()) 
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(optionalEntity.get());		
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody E entity){
		E savedEntity = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
