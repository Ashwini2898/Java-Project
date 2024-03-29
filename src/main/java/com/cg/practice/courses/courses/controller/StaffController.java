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

import com.cg.practice.courses.courses.entity.Staff;
import com.cg.practice.courses.courses.exception.StaffException;
import com.cg.practice.courses.courses.service.StaffService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class StaffController {
	@Autowired
	private StaffService staffService;
	

	//get staff by Id
	//http://localhost:8081/api/staff/1
	@ApiOperation(value = "Get staff by Id",response = Staff.class,tags="get-staff-by-id",consumes="staffId",httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Staff> getStaffById(@PathVariable Integer staffId){
		try {
			Staff staff= staffService.getStaffById(staffId);
			log.info("Product added"+ staff);
			return new ResponseEntity<>(staff,HttpStatus.OK);
		}catch(StaffException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//get all staff
	//http://localhost:8081/api/staff/
	@ApiOperation(value = "Get all staff",response = Staff.class,tags="get-all-staff",httpMethod = "GET")
	@GetMapping("/")
	public ResponseEntity<List<Staff>> getAllStaff(){
		try {
			List<Staff> staffList = staffService.getAllStaff();
			log.info("Returning all staff details");
			return new ResponseEntity<>(staffList,HttpStatus.OK);
		}catch(StaffException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api/staff/
	//add staff    
	@ApiOperation(value = "Add Staff",
			consumes = "receives Staff object as request body",
			response =String.class)
	@PostMapping("/")
	public String addStaff(@RequestBody Staff staff) {
		try {
			Integer status= staffService.addStaff(staff);
			if(status ==1) {
				log.info("Staff:"+staff.getFirstName()+" added to database");
				return "Staff:"+staff.getFirstName()+" added to database";
			}else {
				log.debug("Unable to add staff");
				return "Unable to add staff to database";
			}

		}catch(StaffException e) {
			log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api/staff/1
	//delete staff
	@ApiOperation(value = "Delete Staff",
			consumes = "staffId",
			response =String.class)
	@DeleteMapping("/{id}")
	public String deleteStaff(@PathVariable Integer id) {
		try {
			Integer status= staffService.deleteStaff(id);
			if(status ==1) {
				log.info("Staff: "+id+" deleted from database");
				return "Staff: "+id+" deleted from database";
			}else {
				log.debug("Unable to delete Staff from database");
				return "Unable to delete Staff from database";
			}

		}catch(StaffException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

	//http://localhost:8081/api/staff/
	//update staff
	@ApiOperation(value = "Update Staff",
            consumes = "receives Staff object as request body",
            response =Staff.class)
    @PutMapping("/")
    public ResponseEntity<Staff> updateStaff(@RequestBody Staff staff) {
        try {
            Staff updatedStaff= staffService.updateStaff(staff);
            log.info("Staff: "+ staff.getStaffId()+ " updated");
            return new ResponseEntity<>(updatedStaff,HttpStatus.OK);

 

        }catch(StaffException e) {
            log.error(e.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }


}