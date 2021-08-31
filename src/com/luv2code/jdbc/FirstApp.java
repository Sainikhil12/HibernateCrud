package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class FirstApp {

	public static void main(String[] args) {
	String jdbcurl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
	String user="hbstudent";
	String pass="hbstudent";
		
		try {
			//connecting to database
			System.out.println("Connecting to jdbc"+jdbcurl);
			//getting connection with mysql
			Connection myconn = DriverManager.getConnection(jdbcurl,user,pass);
			System.out.println("Connection was sucessful");
			
		}

		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
