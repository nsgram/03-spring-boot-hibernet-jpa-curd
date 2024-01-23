package com.capgemini.curddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.capgemini.curddemo.dao.StudentDAO;
import com.capgemini.curddemo.entity.Student;

@SpringBootApplication
public class CurddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}
	@Bean
    public CommandLineRunner commandLineRunner(StudentDAO dao) {
		return runner->{ 
			//createStudent(dao);
			createMultipleStudent(dao);
			//readStudent(dao);
			//queryForStudent(dao);
			//queryForStudentByLastName(dao);
			//updateStudent(dao);
			//deleteStudent(dao);
			//deleteAllStudent(dao);
			
			
			};
	}
	private void deleteAllStudent(StudentDAO dao) {
		int deletedItems = dao.deleteAll();
		System.out.println("deleted no of rows count:"+deletedItems);
		
	}
	private void deleteStudent(StudentDAO dao) {
		//delete student by passing id
		dao.delete(8);
		System.out.println("Student deleted");
		
	}
	private void updateStudent(StudentDAO dao) {
		// read data based on primary key
		int sid= 3;
		Student student = dao.findById(sid);
		student.setLastName("P");
		student.setFirstName("P");
		student.setEmail("p@g.c");
		//update student
		dao.update(student);
		System.out.println("Student  updated ::"+student);
		
	}
	private void queryForStudentByLastName(StudentDAO dao) {
		List<Student> list = dao.findLastName("J");
		list.forEach(System.out::println);
		
	}
	private void queryForStudent(StudentDAO dao) {
		List<Student> list = dao.findAll();
		list.forEach(System.out::println);
		
	}
	private void readStudent(StudentDAO dao) {
		Student student = new Student("J", "J", "j@g.c");
		//save student object
		dao.save(student);
		System.out.println("student object saved");
		Student studentRead = dao.findById(student.getSid());
		System.out.println("student object read :"+studentRead);
		
	}
	private void createStudent(StudentDAO dao) {
		//create student object
		Student student = new Student("C", "C", "c@g.c");
		//save student object
		dao.save(student);
		
		//display id of the saved student object
		
		System.out.println("student saved ::"+student.getSid());
	}
	
	private void createMultipleStudent(StudentDAO dao) {
		//create multiple student object
		System.out.println("Create 5 student object");
				Student student_1 = new Student("D", "D", "d@g.c");
				Student student_2 = new Student("E", "E", "e@g.c");
				Student student_3 = new Student("F", "F", "f@g.c");
				Student student_4 = new Student("G", "G", "g@g.c");
				Student student_5 = new Student("H", "H", "h@g.c");
				
		//save student object
				System.out.println("saving the student object");
				dao.save(student_1);
				dao.save(student_2);
				dao.save(student_3);
				dao.save(student_4);
				dao.save(student_5);
				
				System.out.println("student objecect saved ");
				
	}
}
