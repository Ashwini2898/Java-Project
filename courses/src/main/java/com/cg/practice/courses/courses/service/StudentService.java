package com.cg.practice.courses.courses.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.cg.practice.courses.courses.entity.Courses;
import com.cg.practice.courses.courses.entity.Student;

import com.example.demo.exception.StudentException;

public interface StudentService {
public List<Student> getAllStudent() throws StudentException;
	
	public Student getStudentById(Integer id)throws StudentException;
	
	public Integer deleteStudentById(Integer id)throws StudentException;
	public Integer addStudent(Student student)throws StudentException;

public	Student updateStudentById(Student student)throws StudentException;

	

}
