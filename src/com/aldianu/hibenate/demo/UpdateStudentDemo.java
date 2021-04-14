package com.aldianu.hibenate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aldianu.hibenate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			int studentId=7;
			
			//find out the students id:primary key
			
			//get a new session and start a transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id
			System.out.println("\ngeting the student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("updateing student....");
			myStudent.setFirstName("Scooby");
			//commit the transaction
			session.getTransaction().commit();
			
			//
			session =factory.getCurrentSession();
			session.beginTransaction();
			//update email for all student
			session.createQuery("update Student s set s.email='foo@gmail.com' where s.lastName='Doe'  ")
			.executeUpdate();
			
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





