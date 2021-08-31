package com.luv2code.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		//creating a session factory
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
				                 
		//create session
		Session session = factory.getCurrentSession();
		try {
			int studentId=1;
		
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			//retrieve student based on the id:primary key
			System.out.println("\nGetting student with id:"+ studentId);
			

			
			
			Student myStudent = session.get(Student.class,studentId);
			myStudent.setFirstName("Scooby");
			
			//commit the transction
			session.getTransaction().commit();
			
			//New Code for updating all students emails
			session = factory.getCurrentSession();
			session.beginTransaction();
			//update emails for all students
			
			System.out.println("Updating all students list");
			//actual code updating all emails
			session.createQuery("update Student set email='foot@gmail.com'").executeUpdate();
			
			
			//commit the transction
			session.getTransaction().commit();
			
			
			
			
			System.out.println("Done!");
			
			
			 
			
			
			
			
		
			
			
			
			
		}
		finally {
			factory.close();
		}

	}

}
