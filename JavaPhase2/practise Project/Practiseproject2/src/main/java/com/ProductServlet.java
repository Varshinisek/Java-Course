package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>"); 
		// get connection
		Connection con=DBconnection.getConnection();
		
		// create sql command
		String sql="select * from products"; 
		Statement stmt=con.createStatement();

		out.println("<table border=1 width=50% height=10%>"); 
		out.println("<tr><th>productid</th><th>productname</th><th>price</th><th>Quantity</th></tr>"); 
		
		//Execute query and stored in resultset
		ResultSet result=stmt.executeQuery(sql);
		
		//Read records from resultset
		while(result.next()) {
			out.println("<tr><td>"+result.getInt("productid")+"<td>"+result.getString("productname")+"<td>"+result.getInt("price")+"<td>"+result.getInt("Quantity"));		}
		 	out.println("</table>");  
		 	out.println("</html></body>");  
		 	con.close(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}