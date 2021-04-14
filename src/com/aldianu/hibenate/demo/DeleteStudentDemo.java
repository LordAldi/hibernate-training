package com.aldianu.hibenate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aldianu.hibenate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			int studentId=5;
			
			//find out the students id:primary key
			
			//get a new session and start a transaction
			session =factory.getCurrentSession();
			session.beginTransaction();
			//retrieve student based on the id
			System.out.println("\ngeting the student with id: "+studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("deleting student...., "+myStudent);
			session.delete(myStudent);
			
			System.out.println("detele student id=7");
			session.createQuery("delete from Student where id=7").executeUpdate();
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





