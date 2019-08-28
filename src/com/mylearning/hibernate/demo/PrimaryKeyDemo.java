package com.mylearning.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mylearning.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create Session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		// create Session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the java object

			// create 3 student object
			System.out.println("Creating 3 student object....");
			Student tempStudent1 = new Student("Devendra", "Rathore", "rathore344@gmail.com");
			Student tempStudent2 = new Student("Alekhya", "Vallabhaneni", "avallabheneni25@gmail.com");
			Student tempStudent3 = new Student("Priyanka", "Kanwar", "priyanka.rathore3770@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the student.....");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
