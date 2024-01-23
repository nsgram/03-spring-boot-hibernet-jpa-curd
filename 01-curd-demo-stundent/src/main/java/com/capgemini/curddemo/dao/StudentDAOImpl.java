package com.capgemini.curddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.curddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class StudentDAOImpl implements StudentDAO {
    //define the field for entity manager
	private EntityManager entityManager; 
	
	//inject the entity manager using constructor
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager =entityManager;
	}
	
	//implement save() method
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);

	}
   //read data
	@Override
	public Student findById(int sid) {	
		return entityManager.find(Student.class, sid);
	}

	//read all data
	@Override
	public List<Student> findAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findLastName(String theLastName) {
		// create query
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);
		
		theQuery.setParameter("theData", theLastName);
		
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student student) {
		entityManager.merge(student);
		
	}

	@Override
	@Transactional
	public void delete(int sid) {
		//read the student object
		Student student = entityManager.find(Student.class, sid);
		//delete the student  
		entityManager.remove(student);
	}

	@Override
	@Transactional
	public int deleteAll() {
		int deleted = entityManager.createQuery("delete from Student").executeUpdate();
		return deleted;
	}
}
