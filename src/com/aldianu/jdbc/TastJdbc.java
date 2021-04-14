package com.aldianu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TastJdbc {

	public static void main(String[] args) {
		String jdbcUrl ="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("Connecting to database: "+jdbcUrl);
			Connection myConn=DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection Successfull");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
