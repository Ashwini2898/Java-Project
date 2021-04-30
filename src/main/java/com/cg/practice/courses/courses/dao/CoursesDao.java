package com.cg.practice.courses.courses.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.practice.courses.courses.entity.Courses;

public interface CoursesDao extends JpaRepository<Courses,Integer>{

}
