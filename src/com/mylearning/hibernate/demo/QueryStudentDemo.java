package com.mylearning.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mylearning.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory(); 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
 			//start a transaction
			session.beginTransaction();
			
			//Query the student
			List<Student> theStudent = session.createQuery("from Student").getResultList();
			
			displayStudent(theStudent);
			
			//Query student with last name : rathore
			theStudent = session.createQuery("from Student s where s.lastName='rathore'").getResultList();
			
			//display students
			System.out.println("\nStudents with last name Rathore");
			displayStudent(theStudent);
			
			//Query student with last name : rathore or firstName : Alekhya
			theStudent = session.createQuery("from Student s where s.lastName='rathore' OR s.firstName='alekhya'").getResultList();
			
			//display students
			System.out.println("\nStudents with last name Rathore and first name Alekhya");
			displayStudent(theStudent);
			
			//Query student with email LIKE @gmail.com
			theStudent = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
			
			//display students
			System.out.println("\nStudents with email LIKE @gmail.com");
			displayStudent(theStudent);

			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	finally {
		factory.close();
	}
		
	}

	private static void displayStudent(List<Student> theStudent) {
		for(Student tempStudent : theStudent) {
			System.out.println(tempStudent);
		}
	}

}
