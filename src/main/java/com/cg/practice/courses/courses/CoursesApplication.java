package com.cg.practice.courses.courses;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@SpringBootApplication(scanBasePackages = "com.cg.practice.courses.courses")
@EntityScan(basePackages = "com.cg.practice.courses.courses.entity")
@EnableJpaRepositories(basePackages = "com.cg.practice.courses.courses.dao")
@EnableOpenApi
public class CoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesApplication.class, args);
	}


	@Bean
	  public Docket openApiCourseStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-course-store")
	        .select()
	        .paths(coursePaths())
	        .build();
	  }

	  private Predicate<String> coursePaths() {
	    return regex(".*/api/courses/.*");
	  }
	  
	  @Bean
	  public Docket openApiStaffStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-staff-store")
	        .select()
	        .paths(staffPaths())
	        .build();
	  }

	  private Predicate<String> staffPaths() {
	    return regex(".*/api/staff/.*");
	  }
	  
	  @Bean
	  public Docket openApiStudentStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-student-store")
	        .select()
	        .paths(studentPaths())
	        .build();
	  }

	  private Predicate<String> studentPaths() {
	    return regex(".*/api/student/.*");
	  }
	  
	  @Bean
	  public Docket openApiLoginStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-login-store")
	        .select()
	        .paths(loginPaths())
	        .build();
	  }

	  private Predicate<String> loginPaths() {
	    return regex(".*/api/login/.*");
	  }
	  @Bean
	  public Docket openApiStaffLoginStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-Stafflogin-store")
	        .select()
	        .paths(StaffloginPaths())
	        .build();
	  }

	  private Predicate<String> StaffloginPaths() {
	    return regex(".*/api/staffLogin/.*");
	  }
}