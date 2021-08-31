package com.luv2code.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
		//creating a session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
				                 
		//create session
		Session session = factory.getCurrentSession();
		try {
			//create a student object
			System.out.println("Creating the student object");
			Student tempStudent = new Student("Katakam","Sainikhil","sainikhil9032@gmail.com");
			
			//start the transction
			System.out.println("Transaction is started");
			
			session.beginTransaction();
			
			//save the student object
			session.save(tempStudent);
			
			//commit the transction
			session.getTransaction().commit();
			
			
			
		}
		finally {
			factory.close();
		}

	}

}
