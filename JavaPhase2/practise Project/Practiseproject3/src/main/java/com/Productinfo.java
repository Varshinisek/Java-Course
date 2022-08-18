package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Productinfo
 */
public class Productinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid= Integer.parseInt(request.getParameter("txtnum"));
		int price = Integer.parseInt(request.getParameter("txtprice"));
		int quantity = Integer.parseInt(request.getParameter("txtquantity"));
		String productname = request.getParameter("txtname");
		
		HttpSession session =request.getSession();
		session.setAttribute("productname", productname );
		session.setAttribute("price", price);
		session.setAttribute("quantity", quantity);
		session.setAttribute("pid", pid);
		response.sendRedirect("Display.jsp");
	}

}
