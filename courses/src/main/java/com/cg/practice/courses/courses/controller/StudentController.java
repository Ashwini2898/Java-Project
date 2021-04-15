package com.cg.practice.courses.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.practice.courses.courses.entity.Staff;
import com.cg.practice.courses.courses.entity.Student;
import com.cg.practice.courses.courses.exception.StaffException;
import com.cg.practice.courses.courses.service.StudentService;
import com.example.demo.exception.StudentException;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/student")
@Slf4j
public class StudentController {
	@Autowired
	private StudentService studentService;


	//get student by Id
	//http://localhost:8081/api/student/1
	@ApiOperation(value = "Get student by Id",response = Student.class,tags="get-student-by-id",consumes="student",httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		try {
			Student student= studentService.getStudentById(id);
			log.info("Product added"+ student);
			return new ResponseEntity<>(student,HttpStatus.OK);
		}catch(StudentException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	//get all student
	//http://localhost:8081/api/student/
	@ApiOperation(value = "Get all student",response = Student.class,tags="get-all-student",httpMethod = "GET")
	@GetMapping("/")
	public ResponseEntity<List<Student>> getAllStudent(){
		try {
			List<Student> studentList = studentService.getAllStudent();
			log.info("Returning all student details");
			return new ResponseEntity<>(studentList,HttpStatus.OK);
		}catch(StudentException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api/student/
	//add Student    
	@ApiOperation(value = "Add Student",
			consumes = "receives Student object as request body",
			response =String.class)
	@PostMapping("/")
	public String addStudent(@RequestBody Student student) {
		try {
			Integer status= studentService.addStudent(student);
			if(status ==1) {
				log.info("Student:"+student.getFName()+" added to database");
				return "Student:"+student.getFName()+" added to database";
			}else {
				log.debug("Unable to add Student");
				return "Unable to add Student to database";
			}

		}catch(StudentException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api/student/1
	//delete Student
	@ApiOperation(value = "Delete Student",
			consumes = "StudentId",
			response =String.class)
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		try {
			Integer status= studentService.deleteStudentById(id);
			if(status ==1) {
				log.info("Student: "+id+" deleted from database");
				return "Student: "+id+" deleted from database";
			}else {
				log.debug("Unable to delete Student from database");
				return "Unable to delete Student from database";
			}

		}catch(StudentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api/staff/
	//update staff
	@ApiOperation(value = "Update Student",
			consumes = "receives Student object as request body",
			response =Student.class)
	@PutMapping("/")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		try {
			Student updatedStudent= studentService.updateStudentById(student);
			log.info("Student: "+ student.getStudentId()+ " updated");
			return new ResponseEntity<>(updatedStudent,HttpStatus.OK);

		}catch(StudentException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}



}