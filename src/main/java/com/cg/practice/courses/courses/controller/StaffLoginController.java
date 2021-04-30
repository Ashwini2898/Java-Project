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
import com.cg.practice.courses.courses.entity.StaffLogin;
import com.cg.practice.courses.courses.exception.BaseResponse;
import com.cg.practice.courses.courses.exception.ResourceNotFoundException;
import com.cg.practice.courses.courses.service.StaffLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/staffLogin")
@CrossOrigin(origins = "http://localhost:3000")
@Api(value = "Staff")
public class StaffLoginController {
	@Autowired 
    private StaffLoginService staffLoginService;

 

    /**
     * @param staff
     * Login of staff
     * @return
     * @throws ResourceNotFoundException 
     */

 

    @PostMapping("/staffLogin")
    @ApiOperation(value = "SignIn")
    public ResponseEntity<?> signIn( @RequestBody StaffLogin staff) throws ResourceNotFoundException {
        String str = staffLoginService.signIn(staff);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(1);
        baseResponse.setResponse(str);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

 

    /**
     * @throws ResourceNotFoundException 
     * @param staff
     * Logout of staff
     * @return
     * @throws RuntimeException 
     * @throws  
     */
    @PostMapping("/logout") 
    @ApiOperation(value = "SignOut")
    public ResponseEntity<?> signOut( @RequestBody LogOutPayload staff) throws  ResourceNotFoundException {
        String str = staffLoginService.signOut(staff);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(1);
        baseResponse.setResponse(str);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

 

    /**
     * @param staff
     * @param new_password
     * Reset password of staff
     * @return
     * @throws ResourceNotFoundException 
     */
    @PostMapping("/reset/{newPassword}")
    @ApiOperation(value = "Reset Password")
    public ResponseEntity<?> changePassword( @RequestBody StaffLogin staff,@PathVariable String newPassword) throws ResourceNotFoundException {
        String str =staffLoginService.changePassword(staff, newPassword);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatusCode(1);
        baseResponse.setResponse(str);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
    
    @PostMapping("/forgot/{newPassword}")
	@ApiOperation(value = "Forgot Password")
	public ResponseEntity<?> forgotPassword( @RequestBody ForgotPassword staff,@PathVariable String newPassword) throws ResourceNotFoundException {
		String str =staffLoginService.forgotPassword(staff, newPassword);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
}
