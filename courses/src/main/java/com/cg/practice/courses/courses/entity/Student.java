package com.cg.practice.courses.courses.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "student")
public class Student implements Serializable
{
	
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer studentId;
    
    @Column(name = "student_FirstName" , nullable = false)
    private String fName;
    
    @Column(name = "student_LastName" , nullable = false)
    private String lName;
    
    @Column(name = "student_Email" , nullable = false)
    private String Email;
    
    @Column(name = "mobile_no" )
    private String MobileNo;
    
//    @Column(name = "role")
//    @Enumerated(EnumType.STRING)
//    private Role role;
    
    @Column(name = "password" , nullable = false)
    private String Password;
    
//    @ToString.Exclude
//	@JsonIgnore
//    @OneToMany(mappedBy = "student")
//    private Set<Courses> course;
//   
}