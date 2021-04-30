package com.cg.practice.courses.courses.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


	@Entity
	@Table(name="course_details")
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Courses {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Integer id;
		
		@Column(name="course_name" ,nullable=false)
		private String courseName;

		

		@Column(name="start_date")
		private LocalDate startDate;

		@Column(name="end_date")
		private LocalDate endDate;
		
		
//		
//		@Column(name="is_posted")
//		private Integer isPosted;
//		
//		
//		@ToString.Exclude
//		@ManyToOne
//		@JoinColumn(name = "student_id")
//		private Student student;
//
//		@ToString.Exclude
//		@ManyToOne(cascade = CascadeType.ALL)
//		@JoinColumn(name = "staff_id")
//		private Staff staff;



	}



