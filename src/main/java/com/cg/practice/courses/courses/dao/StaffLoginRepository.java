package com.cg.practice.courses.courses.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.practice.courses.courses.entity.Staff;

public interface StaffLoginRepository extends JpaRepository<Staff,Integer> {

	Optional<Staff> findByemail(String email);

}
