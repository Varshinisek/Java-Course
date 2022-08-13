package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * Servlet implementation class Calling
 */
@WebServlet("/Calling")
public class Calling extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calling() {
        super();
        // TODO Auto-generated constructor stub
    }



protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int rollno = Integer.parseInt(request.getParameter("txtrollno"));
	try {
		// Call Connection Method
		Connection con = DBconnection1.getConnection();
		// Write sql command
		CallableStatement stmt = (CallableStatement) con.prepareCall("{call getRecord(?,?,?)}");

		stmt.setInt(1, rollno);
		stmt.registerOutParameter(2, Types.VARCHAR);
		stmt.registerOutParameter(3, Types.INTEGER);
		stmt.execute();

		PrintWriter out = response.getWriter();
		out.println("<table border=2>");
		out.println("<tr><th>Rollno</th><th>Name</th><th>Marks</th></tr>");
		out.println("<tr>");
		out.print("<td>" + rollno + "</td>");
		out.print("<td>" + stmt.getString(2) + "</td>");
		out.print("<td>" + stmt.getInt(3) + "</td>");
		out.println("</tr>");
		out.println("</table>");

		con.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
