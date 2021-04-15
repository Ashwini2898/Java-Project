package com.cg.practice.courses.courses.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.practice.courses.courses.entity.Staff;



@Repository
public interface StaffSpringDataDAO extends JpaRepository<Staff, Integer> {

}
