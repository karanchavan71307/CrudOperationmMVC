package com.hibernate.firstproject.service;

import java.util.List;

import com.hibernate.firstproject.model.Student;

public interface StudentService {

	public List<Student> getAllStudent();

	public Student getStudent(int id);

	public void saveStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int id);
	
	
}
