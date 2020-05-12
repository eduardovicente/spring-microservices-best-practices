package com.vicentemartinez.microservices.app.users.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.vicentemartinez.microservices.app.users.models.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{}