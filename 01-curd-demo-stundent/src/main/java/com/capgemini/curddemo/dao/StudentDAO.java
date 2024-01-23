package com.capgemini.curddemo.dao;

import java.util.List;

import com.capgemini.curddemo.entity.Student;

public interface StudentDAO {
   void save(Student student);
   Student findById(int sid);
   List<Student> findAll();
   List<Student> findLastName(String theLastName);
   void update(Student student);
   void delete(int sid);
   int deleteAll();
   
}
