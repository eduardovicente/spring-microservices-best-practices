package com.vicentemartinez.microservices.app.courses.services;

import org.springframework.stereotype.Service;

import com.vicentemartinez.microservices.app.courses.models.entity.Course;
import com.vicentemartinez.microservices.app.courses.models.repository.CourseRepository;
import com.vicentemartinez.microservices.commons.services.CommonServiceImpl;

@Service
public class CourseServiceImpl extends CommonServiceImpl<Course, CourseRepository> implements CourseService{

}
