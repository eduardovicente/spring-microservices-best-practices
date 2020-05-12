package com.vicentemartinez.microservices.app.users.services;

import org.springframework.stereotype.Service;

import com.vicentemartinez.microservices.app.users.models.entity.Student;
import com.vicentemartinez.microservices.app.users.models.repository.StudentRepository;
import com.vicentemartinez.microservices.commons.services.CommonServiceImpl;

@Service
public class StudentServiceImpl extends CommonServiceImpl<Student, StudentRepository> implements StudentService {}
