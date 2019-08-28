package com.mylearning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mylearning.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			//delete the student
			//System.out.println("Delete student with id: "+studentId);
			//session.delete(myStudent);
			
			//delete student id=2
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit the transaction 
			session.getTransaction().commit();
			
			
			
			System.out.println("Done!");
		}
	finally {
		factory.close();
	}
		
	}

}
