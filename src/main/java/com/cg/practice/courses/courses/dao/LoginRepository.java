package com.cg.practice.courses.courses.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.practice.courses.courses.entity.Student;

public interface LoginRepository extends JpaRepository<Student,Integer>{

	@Query("select cm from Student cm where cm.Email=?1")
	Optional<Student> findByEmail(String Email);

	

	

}
