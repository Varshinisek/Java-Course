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
 * Servlet implementation class DeleteRecord
 */
@WebServlet("/DeleteRecord")
public class DeleteRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno= Integer.parseInt(request.getParameter("txtrollno"));
		
	
		
		
		Connection con = DatabaseConnection.getMyConnection();
		
		String str = " Delete  from   collegestudent where rollno=?";
	 try {
		PreparedStatement ps = con.prepareStatement(str);
		ps.setInt(1, rollno);
		
		
		
		int ans =ps.executeUpdate();
		PrintWriter out=response.getWriter();
		if(ans>0)
			out.println("Record Deleted!!");
		else 
			out.println("Record not Deleted");
		
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}}
	 