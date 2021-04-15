package com.cg.practice.courses.courses.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.practice.courses.courses.dao.StaffSpringDataDAO;
import com.cg.practice.courses.courses.entity.Staff;
import com.cg.practice.courses.courses.exception.StaffException;



@Service
@Transactional
@Primary
public class StaffServiceImpl implements StaffService
{
	@Autowired
	private StaffSpringDataDAO staffSpringDataDAO;
	
	//calling addStaff method of DAO layer
	@Override
	public Integer addStaff(Staff staff) throws StaffException 
	{
		try 
		{
			staffSpringDataDAO.save(staff);
			return 1;
		}
		catch(DataAccessException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StaffException(e.getMessage(),e);
		}
		
	}

	//calling getStaffById method of DAO layer
	@Override
	public Staff getStaffById(Integer staffId) throws StaffException 
	{
		try
		{			
			Optional<Staff> optional= staffSpringDataDAO.findById(staffId);
			if(optional.isPresent())
			{
				return optional.get();
			}
			else
			{
				return null;
			}
		}
		catch(DataAccessException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

	//calling deleteStaff method of DAO layer
	@Override
	public Integer deleteStaff(Integer staffId) throws StaffException 
	{
		try 
		{			
			staffSpringDataDAO.deleteById(staffId);
			return 1;
		}
		catch(DataAccessException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

	//calling getAllStaff method of DAO layer
	@Override
	public List<Staff> getAllStaff() throws StaffException
	{
		try 
		{			
			List<Staff> staffList= 	staffSpringDataDAO.findAll();
			return staffList;
		}
		catch(DataAccessException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

	//calling updateStaff method of DAO layer
	@Override
	public Staff updateStaff(Staff staff) throws StaffException 
	{
		try 
		{			
			Staff updatedStaff= staffSpringDataDAO.save(staff);	
			return updatedStaff;
		}
		catch(DataAccessException e) 
		{
			throw new StaffException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StaffException(e.getMessage(),e);
		}
	}

}
