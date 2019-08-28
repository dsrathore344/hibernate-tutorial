package com.mylearning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mylearning.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory(); 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			//use the session object to save the java object
			
			//create a student object
			System.out.println("Creating a new student object....");
			Student tempStudent = new Student("Devendra", "Rathore", "rathore344@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student.....");
			session.save(tempStudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
	finally {
		factory.close();
	}
		
	}

}
