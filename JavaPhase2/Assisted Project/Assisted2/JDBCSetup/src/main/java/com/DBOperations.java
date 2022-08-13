package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBconnection2;
/**
 * Servlet implementation class DBOperations
 */
@WebServlet("/DBOperations")
public class DBOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBOperations() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
       try {
                 PrintWriter out = response.getWriter();
                 Connection con = DBconnection2.getConnection();
                 Statement stmt =con.createStatement();
                 stmt.executeUpdate("Create database hellovarshinidatabase");
                 out.println("Create database: hellovarshinidatabase<br>");
                 stmt.executeUpdate("use hellovarshinidatabase");
                 out.println("Selected database: hellovarshinidatabase<br>");
                 stmt.executeUpdate("drop hellovarshinidatabasee");
         
                 stmt.close();
                 out.println("Dropped database: hellovarshinidatabase<br>");
                 
       }
       catch(Exception e) {
    	   e.printStackTrace();
       }}}