package com.cg.practice.courses.courses.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.practice.courses.courses.dao.LoginRepository;
import com.cg.practice.courses.courses.entity.ForgotPassword;
import com.cg.practice.courses.courses.entity.LogOutPayload;
import com.cg.practice.courses.courses.entity.Login;
import com.cg.practice.courses.courses.entity.Staff;
import com.cg.practice.courses.courses.entity.Student;
import com.cg.practice.courses.courses.exception.OperationFailedException;
import com.cg.practice.courses.courses.exception.ResourceNotFoundException;



@Service
public class LoginServiceImpl implements LoginService {

	@Autowired // To get a relation with User repository
	private LoginRepository loginRepository;

	
	/**
	 * signOut
	 */
	

	

	/**
	 * signIn
	 * @throws ResourceNotFoundException 
	 */
	
	@Override
	public String signIn(Login Student) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		String str=null;
		Optional<Student> studentObj=loginRepository.findByEmail(Student.getEmail());
		if (!studentObj.isPresent()) {
			System.out.println(studentObj);
			throw new ResourceNotFoundException("USER_NOT_FOUND");
		} else {
			String pwd = studentObj.get().getPassword();
			if (!pwd.equals(Student.getPassword())) {
				throw new ResourceNotFoundException("WRONG_PASSWORD");
			}
			try {
				str = "Sign in sucessfull";
				loginRepository.saveAndFlush(studentObj.get());
			} catch (Exception e) {
				throw new OperationFailedException("OPERATION_FAILED");
			}
		}
		return str;


	}


	/**
	 * changePassword
	 * @throws ResourceNotFoundException 
	 */
	@Override
	public String changePassword(Login Student, String new_password) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		String str = null;
		Optional<Student> studentObj = loginRepository.findByEmail(Student.getEmail());
		if (!studentObj.isPresent()) {
			throw new ResourceNotFoundException("USER_NOT_FOUND");
		} else {
			String pwd = studentObj.get().getPassword();
			if (!pwd.equals(Student.getPassword())) {
				throw new ResourceNotFoundException("WRONG_PASSWORD");
			}
			try {
				studentObj.get().setPassword(new_password);
				loginRepository.saveAndFlush(studentObj.get());
				str = "Password changed sucessfully";
			} catch (Exception e) {
				throw new OperationFailedException("OPERATION_FAILED");
			}
		}
		return str;
	}

	
	@Override
	public String forgotPassword(ForgotPassword Student, String newPassword) throws ResourceNotFoundException {
		String str = null;
		Optional<Student> userObj = loginRepository.findByEmail(Student.getEmail());
		
		if (!userObj.isPresent()) {
			throw new ResourceNotFoundException("USER_NOT_FOUND");
		} else {
			String lastName = userObj.get().getLName();
			if (!lastName.equals(Student.getlastName())) {
				throw new ResourceNotFoundException("USER_NOT_FOUND");
			}
			try {
				userObj.get().setPassword(newPassword);
				loginRepository.saveAndFlush(userObj.get());
				str = "Password updated sucessfully";
			} catch (Exception e) {
				throw new OperationFailedException("OPERATION_FAILED");
			}
		}
		return str;
	}


//	@Override
//	public String signOut(LogOutPayload Student) throws RuntimeException {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	@Override
	public String signOut(LogOutPayload Student) throws RuntimeException {
		String str = null;
		Optional<Student> studentObj=loginRepository.findById(Student.getId());
		//Optional<Student> studentObj = LoginRepository.findById(student.getId());
		if (!studentObj .isPresent()) {
			throw new RuntimeException("USER_NOT_FOUND");
		} else {
			try {
				str = "Sign Out sucessfull";
			loginRepository.saveAndFlush(studentObj .get());
			} catch (Exception e) {
				throw new RuntimeException("OPERATION_FAILED");
			}
		}
		return str;
	
	}
}