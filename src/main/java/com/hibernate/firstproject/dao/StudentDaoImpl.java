package com.hibernate.firstproject.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.firstproject.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Student> getAllStudent() {

		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Student";
		Query<Student> query = session.createQuery(hql, Student.class);

		List<Student> list = query.list();
		return list;
	}

	@Override
	public Student getStudent(int id) {

		Session session = this.sessionFactory.getCurrentSession();

		Student student = session.get(Student.class, id);
		return student;
	}

	@Override
	public void saveStudent(Student student) {

		Session session = this.sessionFactory.openSession();

		// Transaction tx = session.beginTransaction();

		session.saveOrUpdate(student);
		// tx.commit();
		// session.close();

	}

	@Override
	public void updateStudent(Student student) {

		Session session = this.sessionFactory.getCurrentSession();
		session.merge(student);

	}

	@Override
	public void deleteStudent(int id) {

		Session session = this.sessionFactory.getCurrentSession();

		Student student = session.get(Student.class, id);

		if (student != null) {
			session.delete(student);
		} else {
			System.out.println("data not present in database..");
		}
	}

}
