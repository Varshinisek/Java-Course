package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentSevlet
 */
@WebServlet("/StudentSevlet")
public class StudentSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollno=Integer.parseInt(request.getParameter("txtrollno"));
		String name=request.getParameter("txtname");
		int marks=Integer.parseInt(request.getParameter("txtmarks"));
		
		
		//Establish Connection with database
		try {
			Connection con=DatabaseConnection.getMyConnection();	
			
			//Write Query
			
			String str="Insert into collegestudent (rollno,name,marks) values(?,?,?)";
			//string str= "update student set marks=? where rollno=?"
			//String str="delete from student where rollno=?"
			//to execute query create object of preparedSatement
			PreparedStatement  ps=con.prepareStatement(str);
			ps.setInt(1,rollno );
			ps.setString(2, name);
			ps.setInt(3, marks);
						
			//execute query
			int ans =ps.executeUpdate();
			PrintWriter out=response.getWriter();
			if(ans>0)
				out.println("Record inserted");
			else
				out.println("Record not inserted");
		
			//close connection
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
}
}
