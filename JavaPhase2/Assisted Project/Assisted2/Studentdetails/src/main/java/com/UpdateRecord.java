package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateRecord
 */
@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int rollno= Integer.parseInt(request.getParameter("txtrollno"));
		String name =request.getParameter("txtname");
		int marks =Integer.parseInt(request.getParameter("txtmarks"));
		 
		
		Connection con= DatabaseConnection.getMyConnection();
		
		String str ="update collegestudent set name=? ,marks=? where rollno=?";
		
		
		try {
			PreparedStatement ps =con.prepareCall(str);
			 ps.setString(1, name);
			 ps.setInt(2, marks);
			 ps.setInt(3, rollno);
			 
			
			int ans =ps.executeUpdate();
			PrintWriter out =response.getWriter();
			if(ans>0)
				out.println("Record Updated");
			else
				out.println("Record not Updated");
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}}