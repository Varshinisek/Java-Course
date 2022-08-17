package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
@WebServlet("/ProductDAO")
public class ProductDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid= Integer.parseInt(request.getParameter("txtproductid"));
		int price = Integer.parseInt(request.getParameter("txtprice"));
		int quantity = Integer.parseInt(request.getParameter("txtquantity"));
		String product_name = request.getParameter("txtproductname");
		// put values in Object
		Product prod = new Product();
		 prod.setPrice(price);
		 prod.setProduct_id(pid);
		 prod.setProduct_name(product_name);
		 prod.setQuantity(quantity);
		
		
	
		//create connection
		Configuration config=new Configuration();
		SessionFactory sessionFactory=config.configure().buildSessionFactory();


		//open connection
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//save object as record
		int i=(Integer)session.save(prod);
		session.getTransaction().commit();

		session.close();
		PrintWriter out = response.getWriter();
		if (i > 0)
			out.println("Product inserted");
		else
			out.println("Product not inserted");








}

}