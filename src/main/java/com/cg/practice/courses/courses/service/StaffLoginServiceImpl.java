package com.cg.practice.courses.courses.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.practice.courses.courses.dao.StaffLoginRepository;
import com.cg.practice.courses.courses.entity.ForgotPassword;
import com.cg.practice.courses.courses.entity.LogOutPayload;
import com.cg.practice.courses.courses.entity.Role;
import com.cg.practice.courses.courses.entity.Staff;
import com.cg.practice.courses.courses.entity.StaffLogin;
import com.cg.practice.courses.courses.exception.ResourceNotFoundException;


@Service
public class StaffLoginServiceImpl implements StaffLoginService {
	@Autowired 
	private StaffLoginRepository staffLoginRepository;



	/**
	 *signIn
	 * @throws ResourceNotFoundException 
	 */
	@Override
	public String signIn(StaffLogin staff) throws ResourceNotFoundException {
		String str = null;
		Optional<Staff> staffObj = staffLoginRepository.findByemail(staff.getEmail());
		if (!staffObj.isPresent()) {
			System.out.println(staffObj);
			throw new ResourceNotFoundException("USER_NOT_FOUND");
		} else {
			String pwd = staffObj.get().getPassword();
			Role role=staffObj.get().getRole();
			if (!pwd.equals(staff.getPassword())) {
				throw new ResourceNotFoundException("WRONG_PASSWORD");
			}
			if(!role.equals(staff.getRole())) {
				throw new ResourceNotFoundException("USER_NOT_FOUND");
			}
			try {
				str = "Sign in sucessfull";
				staffLoginRepository.saveAndFlush(staffObj.get());
			} catch (Exception e) {
				throw new RuntimeException("OPERATION_FAILED");
			}
		}
		return str;



	}


	/**
	 * signOut
	 * @throws ResourceNotFoundException 
	 */
	@Override
	public String signOut(LogOutPayload staff) throws RuntimeException {
		String str = null;
		Optional<Staff> staffObj = staffLoginRepository.findById(staff.getId());
		if (!staffObj.isPresent()) {
			throw new RuntimeException("USER_NOT_FOUND");
		} else {
			try {
				str = "Sign Out sucessfull";
				staffLoginRepository.saveAndFlush(staffObj.get());
			} catch (Exception e) {
				throw new RuntimeException("OPERATION_FAILED");
			}
		}
		return str;
	}

	/**
	 * changePassword
	 * @throws ResourceNotFoundException 
	 */
	@Override
	public String changePassword(StaffLogin staff, String new_password) throws ResourceNotFoundException {
		String str = null;
		Optional<Staff> staffObj = staffLoginRepository.findByemail(staff.getEmail());
		if (!staffObj.isPresent()) {
			throw new ResourceNotFoundException("USER_NOT_FOUND");
		} else {
			String pwd = staffObj.get().getPassword();
			if (!pwd.equals(staff.getPassword())) {
				throw new ResourceNotFoundException("WRONG_PASSWORD");
			}
			try {
				staffObj.get().setPassword(new_password);
				staffLoginRepository.saveAndFlush(staffObj.get());
				str = "Password changed sucessfully";
			} catch (Exception e) {
				throw new RuntimeException("OPERATION_FAILED");
			}
		}
		return str;
	}
	
	@Override
	public String forgotPassword(ForgotPassword staff, String newPassword) throws ResourceNotFoundException {
		String str = null;
		Optional<Staff> userObj = staffLoginRepository.findByemail(staff.getEmail());
		
		if (!userObj.isPresent()) {
			throw new ResourceNotFoundException("USER_NOT_FOUND");
		} else {
			String lastName = userObj.get().getLastName();
			if (!lastName.equals(staff.getlastName())) {
				throw new ResourceNotFoundException("USER_NOT_FOUND");
			}
			try {
				userObj.get().setPassword(newPassword);
				staffLoginRepository.saveAndFlush(userObj.get());
				str = "Password updated sucessfully";
			} catch (Exception e) {
				throw new RuntimeException("OPERATION_FAILED");
			}
		}
		return str;
	}


	
}

