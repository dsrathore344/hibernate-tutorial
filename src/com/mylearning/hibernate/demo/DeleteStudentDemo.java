package com.mylearning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mylearning.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create Session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory(); 
		
		//create Session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student id: primary key
			System.out.println("\nGetting student with id: "+ studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("updating student:");
			
			myStudent.setFirstName("Rajendra");
		
			//commit the transaction 
			session.getTransaction().commit();
			
			//NEW CODE
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//update all student email address
			System.out.println("\nUpdate email for all student ");
			session.createQuery("update Student set email='deva@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
	finally {
		factory.close();
	}
		
	}

}
