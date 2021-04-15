package com.cg.practice.courses.courses.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.cg.practice.courses.courses.entity.Courses;
import com.cg.practice.courses.courses.exception.CoursesException;

public interface CoursesService {

	public List<Courses> getAllCoureses() throws CoursesException;
	
	public Courses getCourseById(Integer id)throws CoursesException;
	
	public Integer deleteCourseById(Integer id)throws CoursesException;
	public Integer addCourse(Courses course)throws CoursesException;

public	Courses updateCourseById(Courses course)throws CoursesException;

	public List<Courses> getAllCourses(List<Courses> courseList, HttpStatus ok)throws CoursesException;

	public Courses getupdateCourseById(Courses updatedCourses, HttpStatus ok);

	

	//public List<Courses> getAllCourses(List<Courses> courseList, HttpStatus ok);
}
