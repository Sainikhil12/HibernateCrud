package com.luv2code.hibernate.create;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Student;

public class DeleteStudentDemo {

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
			//deleting the student
			
			//System.out.println("Deleting the student data with id =1"+myStudent);
			
			//session.delete(myStudent);
			
			//deleting the student id=2
		
			//another way of deleting with HQL
			System.out.println("Deleting the student with id =2");
			
			session.createQuery("delete from Student where id =2").executeUpdate();
			//commit the transction
			session.getTransaction().commit();
			
			
			
			
			
			
			System.out.println("Done!");
			
			
			 
			
			
			
			
		
			
			
			
			
		}
		finally {
			factory.close();
		}

	}

}
