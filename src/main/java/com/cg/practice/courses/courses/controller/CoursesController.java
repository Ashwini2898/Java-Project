package com.cg.practice.courses.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.server.ResponseStatusException;

import com.cg.practice.courses.courses.entity.Courses;
import com.cg.practice.courses.courses.exception.CoursesException;
import com.cg.practice.courses.courses.service.CoursesService;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class CoursesController {
	@Autowired
	CoursesService courseService;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiOperation(value = "Get all courses",response = Courses.class,tags="get-all-courses",httpMethod = "GET")
	
	@GetMapping("/")
public ResponseEntity getAllCourses(){
		try {
			List<Courses> courseList = courseService.getAllCoureses();
			log.info("Returning all courses details");
			return new ResponseEntity(courseList,HttpStatus.OK);
		}catch(CoursesException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
}
	

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Get courses by Id",response =Courses.class,tags="get-courses-by-id",consumes="id",httpMethod = "GET")
	
	@GetMapping("/{id}")
public ResponseEntity getCourseById(@PathVariable Integer id) {
		try {
			Courses course= courseService.getCourseById(id);
			log.info("Course added"+ course);
			return new  ResponseEntity(course,HttpStatus.OK);
		}catch(CoursesException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
}
	
	

	@SuppressWarnings("rawtypes")
	@ApiOperation(value = "Update Courses",
			consumes = "receives course object as request body",
			response =Courses.class)
	@PutMapping("/")
public ResponseEntity <Courses>updateCourseById(@RequestBody Courses course) {
		try {
			Courses updatedCourses= courseService.updateCourseById(course);
			log.info("Course: "+ course.getId()+ " updated");
			return new ResponseEntity(updatedCourses,HttpStatus.OK);

		}catch(CoursesException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
}
	}
	
    @ApiOperation(value = "Delete Course",
	consumes = "id",
	response =String.class)
	@DeleteMapping("/{id}")
	public String deleteCourseById(@PathVariable Integer id) {
    	try {
			Integer status= courseService.deleteCourseById(id);
			if(status ==1) {
				log.info("Course: "+id+" deleted from database");
				return "Course: "+id+" deleted from database";
			}else {
				log.debug("Unable to delete Course from database");
				return "Unable to delete Course from database";
			}

		}catch(CoursesException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
    
   
	@ApiOperation(value = "Add Courses",
	consumes = "receives course object as request body",
	response =String.class)
	@PostMapping("/")
	public String addCourse(@RequestBody Courses course) {
try {
			
			Integer status= courseService.addCourse(course);
			if(status ==1) {
				log.info("Course:"+course.getId()+" added to database");
				return "Course:"+course.getId()+" added to database";
			}else {
				log.debug("Unable to add Course");
				return "Unable to add Course to database";
			}

		}catch(CoursesException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
}







