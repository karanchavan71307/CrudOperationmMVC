package com.hibernate.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)

public class FirstProjectWithHibernateApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(FirstProjectWithHibernateApplication.class,
				args);

//		StudentService studentService = context.getBean(StudentService.class);
//		
//		Student std=new Student();
//		//std.setId(101);
//		std.setName("krn");
//		std.setEmail("krn$32");
//		std.setPassword("taju!23");
//		
//		
//		int saveStudent = studentService.saveStudent(std);
//		System.out.println(saveStudent);
		
		
	}

}
