package com.cg.practice.courses.courses.service;

import com.cg.practice.courses.courses.entity.ForgotPassword;
import com.cg.practice.courses.courses.entity.LogOutPayload;
import com.cg.practice.courses.courses.entity.Login;
import com.cg.practice.courses.courses.exception.ResourceNotFoundException;

public interface LoginService {
	   /**
	    * Sign in customer
	    * @param customerMaster
	    * @return sign in successful
	    * else throw invalid customer
	 * @throws ResourceNotFoundException 
	    */
	    public String signIn(Login Student) throws ResourceNotFoundException;

	    /**
	     * Sign out 
	     * @param customerMaster
	     * @return sign out successful
	     * @throws ResourceNotFoundException 
	     * @throws Exception 
	     */

	    public String signOut(LogOutPayload Student) throws  RuntimeException;
	    
	    /**
	     * Change Password
	     * @param customerMaster
	     * @param new_password
	     * @return changed password
	     * @throws ResourceNotFoundException 
	     */
	    public String changePassword(Login Student, String new_password) throws ResourceNotFoundException;
	    
	    public String forgotPassword(ForgotPassword Student, String new_password) throws ResourceNotFoundException;


	}
