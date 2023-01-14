package com.hibernate.firstproject.dao;

import java.util.List;

import com.hibernate.firstproject.model.Student;

public interface StudentDao {
	
	public List<Student> getAllStudent();

	public Student getStudent(int id);

	public void saveStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int id);

}
