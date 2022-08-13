package com;

import java.sql.*;
import java.util.Collection;
public class DBconnection4 {
static Connection con=null;

	public static Connection getConnection(){
		try {
	// load Driver class loader to load driver class in memolry at runtime
		Class.forName("com.mysql.cj.jdbc.Driver");
	String url ="jdbc:mysql://localhost:3306/collegedetails";
	String user ="root";
	String password="Sekar@12345";
	con =DriverManager.getConnection(url,user,password);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return con;
}}

	