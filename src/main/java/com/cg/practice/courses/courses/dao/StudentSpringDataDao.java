package com.cg.practice.courses.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.cg.practice.courses.courses.entity.Student;



@Repository
public interface StudentSpringDataDao extends JpaRepository<Student, Integer> {

}
