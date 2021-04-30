package com.cg.practice.courses.courses.entity;
import  com.cg.practice.courses.courses.entity.Role;
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
@Table(name = "staff")
public class Staff 
{
	
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "staff_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer staffId;
    
    
    @Column(name = "staff_FirstName" , nullable = false)
    private String firstName;
    
    @Column(name = "staff_LastName" , nullable = false)
    private String lastName;
    
    @Column(name = "staff_Email" , nullable = false)
    private String email;
    
    @Column(name = "mobile_no" )
    private String mobileNo;
    
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @Column(name = "password" , nullable = false)
    private String password;

//	public Role getRole() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
//    @ToString.Exclude
//	@JsonIgnore
//    @OneToMany(mappedBy = "staff")
//    private Set<Courses> course;
   
}