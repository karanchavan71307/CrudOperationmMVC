package com.hibernate.firstproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.firstproject.dao.StudentDao;
import com.hibernate.firstproject.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Transactional
	public List<Student> getAllStudent() {

		List<Student> allStudent = this.studentDao.getAllStudent();
		return allStudent;
	}

	@Transactional
	public Student getStudent(int id) {

		Student student = this.studentDao.getStudent(id);
		return student;
	}

	@Transactional
	public void saveStudent(Student student) {

		this.studentDao.saveStudent(student);
			

	}

	@Transactional
	public void updateStudent(Student student) {

		this.studentDao.updateStudent(student);

	}

	@Transactional
	public void deleteStudent(int id) {

		this.studentDao.deleteStudent(id);
	}

}
