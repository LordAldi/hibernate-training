package com.aldianu.hibenate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aldianu.hibenate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
				SessionFactory factory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
				
				// create session
				Session session = factory.getCurrentSession();
				
				try {			
					// create 3 student object
					System.out.println("Creating 3 student object...");
					Student tempStudent1 = new Student("John", "Doe", "john@aldianu.com");
					Student tempStudent2 = new Student("Marry", "Public", "marry@aldianu.com");
					Student tempStudent3 = new Student("Bonita", "Applembum", "bonita@aldianu.com");
					// start a transaction
					session.beginTransaction();
					
					// save the student object
					System.out.println("Saving the students...");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					// commit transaction
					session.getTransaction().commit();
					
					System.out.println("Done!");
				}
				finally {
					factory.close();
				}

	}

}
