package com.cg.practice.courses.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.practice.courses.courses.entity.ForgotPassword;
import com.cg.practice.courses.courses.entity.LogOutPayload;
import com.cg.practice.courses.courses.entity.Login;
import com.cg.practice.courses.courses.exception.BaseResponse;
import com.cg.practice.courses.courses.exception.ResourceNotFoundException;
import com.cg.practice.courses.courses.service.LoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "login")

public class LoginController {

	 @Autowired 
	    private LoginService loginService;

	 @PostMapping("/login") 
	    @ApiOperation(value = "SignIn")
	    public ResponseEntity<?> signIn( @RequestBody Login student) throws ResourceNotFoundException {
	        String str = loginService.signIn(student);
	        BaseResponse baseResponse = new BaseResponse();
	        baseResponse.setStatusCode(1);
	        baseResponse.setResponse(str);
	        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	    }
	 
	 @PostMapping("/reset/{newPassword}")
	    @ApiOperation(value = "Reset Password")
	    public ResponseEntity<?> changePassword( @RequestBody Login student,@PathVariable String newPassword) throws ResourceNotFoundException {
	        String str =loginService.changePassword(student, newPassword);
	        BaseResponse baseResponse = new BaseResponse();
	        baseResponse.setStatusCode(1);
	        baseResponse.setResponse(str);
	        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	    }


@PostMapping("/forgot/{newPassword}")
@ApiOperation(value = "Forgot Password")
public ResponseEntity<?> forgotPassword( @RequestBody ForgotPassword student,@PathVariable String newPassword) throws ResourceNotFoundException {
	String str =loginService.forgotPassword(student, newPassword);
	BaseResponse baseResponse = new BaseResponse();
	baseResponse.setStatusCode(1);
	baseResponse.setResponse(str);
	return new ResponseEntity<>(baseResponse, HttpStatus.OK);
}


/**
 * @param customerMaster
 * Logout of customer
 * @return
 * @throws Exception 
 */
@PostMapping("/logout") 
@ApiOperation(value = "SignOut")
public ResponseEntity<?> signOut( @RequestBody LogOutPayload student) throws ResourceNotFoundException {
    String str = loginService.signOut(student);
    BaseResponse baseResponse = new BaseResponse();
    baseResponse.setStatusCode(1);
    baseResponse.setResponse(str);
    return new ResponseEntity<>(baseResponse, HttpStatus.OK);
}

}
