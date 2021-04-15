package com.cg.practice.courses.courses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.practice.courses.courses.dao.CoursesDao;
import com.cg.practice.courses.courses.entity.Courses;
import com.cg.practice.courses.courses.exception.CoursesException;
@Service
@Transactional
@Primary
public class CoursesServiceImpl implements CoursesService {

	@Autowired
	private CoursesDao coursesDao;
//	@Override
//	public List<Courses> getAllCoureses()throws CoursesException {
//		// TODO Auto-generated method stub
//		return coursesDao.findAll();
//	}

	@Override
	public List<Courses> getAllCoureses() throws CoursesException
	{
		try 
		{			
			List<Courses> couresesList = 	coursesDao.findAll();
			return couresesList;
		}
		catch(DataAccessException e) 
		{
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new CoursesException(e.getMessage(),e);
		}
	}
//	@Override
//	public Courses getCourseById(Integer id) throws CoursesException{
//		// TODO Auto-generated method stub
//	
//		return coursesDao.getOne(id);
//	}

	@Override
	public Courses getCourseById(Integer id) throws CoursesException{
		try
		{			
			Optional<Courses> optional= coursesDao.findById(id);
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
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new CoursesException(e.getMessage(),e);
		}
	}
	
	
//	@Override
//	public Courses updateCourseById(Courses course) throws CoursesException{
//		// TODO Auto-generated method stub
//		coursesDao.save(course);
//		return course;
//		
//	}

	@Override
	public Courses updateCourseById(Courses course) throws CoursesException 
	{
		try 
		{			
			 coursesDao.save(course);	
			return course;
		}
		catch(DataAccessException e) 
		{
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new CoursesException(e.getMessage(),e);
		}
	}

//	@Override
//	public Integer deleteCourseById(Integer parseInt)throws CoursesException {
//		// TODO Auto-generated method stub
//		Courses entity=coursesDao.getOne(parseInt);
//		coursesDao.delete(entity);
//		return null;
//	}
	
	@Override
	public Integer deleteCourseById(Integer id) throws CoursesException 
	{
		try 
		{			
			coursesDao.deleteById(id);
			return 1;
		}
		catch(DataAccessException e) 
		{
			throw new CoursesException(e.getMessage(),e);
		}
		catch(Exception e)
		{
			throw new CoursesException(e.getMessage(),e);
		}
	}

	@Override
	public Integer addCourse(Courses course) throws CoursesException{
		// TODO Auto-generated method stub
	try {	coursesDao.save(course);
		return 1;
	}
	catch(DataAccessException e) 
	{
		throw new CoursesException(e.getMessage(),e);
	}
	catch(Exception e)
	{
		throw new CoursesException(e.getMessage(),e);
	}
	}

	
	@Override
	public List<Courses> getAllCourses(List<Courses> courseList, HttpStatus ok) throws CoursesException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Courses getupdateCourseById(Courses updatedCourses, HttpStatus ok) {
		// TODO Auto-generated method stub
		return null;
	}

}




//public class AdvertisementServiceImpl implements AdvertisementService
//{
//	@Autowired
//	private AdvertisementSpringDataDAO advertisementSpringDataDAO;
//	
//	@Autowired
//	private CustomerSpringDataDAO customerSpringDataDAO;
//	
//	@Autowired
//	private StaffSpringDataDAO staffSpringDataDAO;
//	
//	//calling addAdvertisement method of DAO layer
//	
//
	


//	//calling updateAdvertisement method of DAO layer
//	@Override
//	public AdvertisementDetails updateAdvertisement(AdvertisementDetails advertisement) throws AdvertisementException 
//	{
//		try 
//		{			
//			AdvertisementDetails updatedAdvertisement= advertisementSpringDataDAO.save(advertisement);	
//			return updatedAdvertisement;
//		}
//		catch(DataAccessException e) 
//		{
//			throw new AdvertisementException(e.getMessage(),e);
//		}
//		catch(Exception e)
//		{
//			throw new AdvertisementException(e.getMessage(),e);
//		}
//	}
//
//}
