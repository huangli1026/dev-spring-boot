package com.huangli.cruddemo;

import com.huangli.cruddemo.dao.StudentDAO;
import com.huangli.cruddemo.dao.StudentDAOImpl;
import com.huangli.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
//			createStudent(studentDAO);

			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);
			
//			queryForStudent(studentDAO);

//			queryForStudentByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);


	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);

		Student myStudent=studentDAO.findById(studentId);

		System.out.println("Update student...");
		//change first name to "Scooby"
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);

		//display updated student
		System.out.println("Updated student: "+myStudent);

	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudent=studentDAO.findByLastName("Doe");
		//display list of students
		for(Student tempStudent: theStudent){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudent=studentDAO.findAll();

		//display list of students
		for(Student tempStudent: theStudent){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent=new Student("Daffy", "Duck", "daffy@huangli.com");
		//save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId= tempStudent.getId();
		System.out.println("Saved student. Generated id: "+theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);
		//display student
		System.out.println("Found the student:"+theId);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1=new Student("John", "Doe", "john@huangli.com");
		Student tempStudent2=new Student("Mary", "Public", "mary@huangli.com");
		Student tempStudent3=new Student("Bonita", "Applebum", "bonita@huangli.com");


		//save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent=new Student("Paul", "Doe", "paul@huangli.com");
		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}
}
