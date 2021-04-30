package com.cg.practice.courses.courses.service;
import java.util.List;

import com.cg.practice.courses.courses.entity.Staff;
import com.cg.practice.courses.courses.exception.StaffException;


public interface StaffService 
{
	public Integer addStaff(Staff staff) throws StaffException;
	public Staff getStaffById(Integer staffId) throws StaffException;
	public Integer deleteStaff(Integer staffId) throws StaffException;
	public List<Staff> getAllStaff() throws StaffException;
	public Staff updateStaff(Staff staff) throws StaffException;
}