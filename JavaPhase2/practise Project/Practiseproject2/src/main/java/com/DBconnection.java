package com;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBconnection {
	
	static Connection con=null;

	public static Connection getConnection(){
		try {
	// load Driver class loader to load driver class in memolry at runtime
		Class.forName("com.mysql.cj.jdbc.Driver");
	String url ="jdbc:mysql://localhost:3306/product";
	String user ="root";
	String password="Sekar@12345";
	con =DriverManager.getConnection(url,user,password);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return con;
	
	

	}}
