package com.cg.practice.courses.courses.service;


import com.cg.practice.courses.courses.entity.ForgotPassword;
import com.cg.practice.courses.courses.entity.LogOutPayload;
import com.cg.practice.courses.courses.entity.StaffLogin;
import com.cg.practice.courses.courses.exception.ResourceNotFoundException;

public interface StaffLoginService {
	 /**
     * sign in staff
     * @param staff
     * @return sign in successful
     * else throw invalid staff
	 * @throws ResourceNotFoundException 
     */
    public String signIn(StaffLogin staff) throws ResourceNotFoundException;
    
    /**
     * sign out staff
     * @param staff
     * @return sign out successful
     * @throws ResourceNotFoundException 
     * 
     */
    public String signOut(LogOutPayload staff) throws ResourceNotFoundException;

 
    /**
     * change password
     * @param staff
     * @param new_password
     * @return changed password
     * @throws ResourceNotFoundException 
     */
    public String changePassword(StaffLogin staff, String new_password) throws ResourceNotFoundException;
    /**
     * 
     * @param staff
     * @param newPassword
     * @return
     * @throws ResourceNotFoundException 
     */
    public String forgotPassword(ForgotPassword staff, String newPassword) throws ResourceNotFoundException;
}
