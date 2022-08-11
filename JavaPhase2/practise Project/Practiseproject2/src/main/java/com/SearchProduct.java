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
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Pid=Integer.parseInt(request.getParameter("Productid"));
		PrintWriter out=response.getWriter();
		try { 
			response.setContentType("text/html");
			out.println("<html><body>"); 
			
			Connection con=DBconnection.getConnection();
			String query="select * from products  where productid="+Pid+"";
			Statement stmt=con.createStatement();

			out.println("<table border=1 width=50% height=10%>"); 
			out.println("<tr><th>productid</th><th>productname</th><th>price</th><th>Quantity</th></tr>"); 
			
			
			ResultSet result=stmt.executeQuery(query);
		
			int count=0;

			//Read records from resultset
			while(result.next()) {
				out.println("<tr><td>"+result.getInt("productid")+"<td>"+result.getString("productname")+"<td>"+result.getInt("price")+"<td>"+result.getInt("Quantity"));		
				count++;
				}
			 	out.println("</table>");  
			 	out.println("</html></body>");  
			 	con.close(); 
			
			if(count==0) 
				out.println("<h1>There is no product in the given Product id</h1>");
				
	}
		catch(Exception e) {
			e.printStackTrace();
		}}}

