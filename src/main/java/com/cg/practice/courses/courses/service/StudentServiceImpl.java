package com.cg.practice.courses.courses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.practice.courses.courses.dao.StudentSpringDataDao;
import com.cg.practice.courses.courses.entity.Student;
import com.cg.practice.courses.courses.exception.StudentException;




@Service
@Transactional
@Primary
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentSpringDataDao studentSpringDataDAO;
	
	//calling addStaff method of DAO layer
	@Override
	public Integer addStudent(Student student) throws StudentException 
	{
		try 
		{
			studentSpringDataDAO.save(student);
			return 1;
		}
		catch(DataAccessException e) 
		{
			throw new StudentException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StudentException(e.getMessage(),e);
		}
		
	}

	//calling getStaffById method of DAO layer
	@Override
	public Student getStudentById(Integer studentId) throws StudentException 
	{
		try
		{			
			Optional<Student> optional= studentSpringDataDAO.findById(studentId);
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
			throw new StudentException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StudentException(e.getMessage(),e);
		}
	}

	//calling deleteStaff method of DAO layer
	@Override
	public Integer deleteStudentById(Integer studentId) throws StudentException 
	{
		try 
		{			
			studentSpringDataDAO.deleteById(studentId);
			return 1;
		}
		catch(DataAccessException e) 
		{
			throw new StudentException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StudentException(e.getMessage(),e);
		}
	}

	//calling getAllStaff method of DAO layer
	@Override
	public List<Student> getAllStudent() throws StudentException
	{
		try 
		{			
			List<Student> studentList= 	studentSpringDataDAO.findAll();
			return studentList;
		}
		catch(DataAccessException e) 
		{
			throw new StudentException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StudentException(e.getMessage(),e);
		}
	}

	//calling updateStaff method of DAO layer
	@Override
	public Student updateStudentById(Student student) throws StudentException 
	{
		try 
		{			
			Student updatedStudent= studentSpringDataDAO.save(student);	
			return updatedStudent;
		}
		catch(DataAccessException e) 
		{
			throw new StudentException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new StudentException(e.getMessage(),e);
		}
	}

	
	

}
