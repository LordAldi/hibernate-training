package com.aldianu.hibenate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aldianu.hibenate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			//query the student
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			displayStudents(theStudents);
			
			
			//query the student:lastname :Doct
			theStudents = session.createQuery("from Student s where s.lastName='Doct'").getResultList();
			System.out.println("\n\n the student with lastname of doct");
			displayStudents(theStudents);
			
			//query the student:lastname :Doct or firstName: Marry
			theStudents = session.createQuery("from Student s where s.lastName='Doct' OR s.firstName='Marry'").getResultList();
			System.out.println("\n\n the student with lastname of doct or first name od marry");
			displayStudents(theStudents);
			
			//query the student:email like %aldianu.com
			theStudents = session.createQuery("from Student s where s.email LIKE '%aldianu.com'").getResultList();
			System.out.println("\n\n the student with email end with aldianu.com");
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		//display the student  
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}





