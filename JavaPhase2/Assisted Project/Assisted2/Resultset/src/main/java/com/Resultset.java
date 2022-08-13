package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resultset
 */
@WebServlet("/Resultset")
public class Resultset extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resultset() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			Connection con = DBconnection4.getConnection();
			String sql ="select * from collegestudent";
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			out.println("<table border=1 width=50% height=10%>"); 
			out.println("<tr><th>rollno</th><th>name</th><th>marks</th></tr>");
			ResultSet rs = stmt.executeQuery(sql);

			out.println("Before Changes All Records...<br>");

			out.println("Rollno  Name<br>");

			while (rs.next()) {
				out.println("<tr><td>"+rs.getInt("rollno") + "<td>"+ rs.getString("name") +"<td>"+rs.getInt("marks")+ "<br>");

			}
			out.println("</table>"); 
             
			 
		 	
		 	response.setContentType("text/html");
			// inserting a new row
			rs.moveToInsertRow();//insert empty row
			rs.updateInt("rollno", 31);
			rs.updateString("name", "abiramii");
			rs.updateInt("marks", 80);
			rs.insertRow();// insert all values in that empty row
			
			// updating 2nd row – changing name to Seetha
			rs.absolute(2);
			rs.updateString("name", "Seetha");
			rs.updateRow();

			out.println("<table border=1 width=50% height=10%>"); 
			out.println("<tr><th>rollno</th><th>name</th><th>marks</th></tr>");
			out.println("After Changes All Records...<br>");
			rs.beforeFirst();// to move cursor in begining of resultset


			while (rs.next()) {
				out.println("<tr><td>"+rs.getInt("rollno") + "<td>"+ rs.getString("name") +"<td>"+rs.getInt("marks")+"<tr><br>");
				out.println("</table>");
				 
			}
		} catch (Exception e) {
			out.println(e);
			e.printStackTrace();
		}

	}
}