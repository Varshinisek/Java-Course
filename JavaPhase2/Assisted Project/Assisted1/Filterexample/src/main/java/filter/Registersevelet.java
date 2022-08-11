package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Registersevelet
 */
@WebFilter("/RegisterServlet")
public class Registersevelet implements Filter {

    /**
     * Default constructor. 
     */
    public Registersevelet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String pan=request.getParameter("pan");
		System.out.println("Hi from filter");
		if(pan==null|| !pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")) {
			
			PrintWriter out =response.getWriter();
			request.getRequestDispatcher("File.html").include(request, response);
			out.println("<center><p style=\"color:Red; font-size:25px;\">Invalid user or password");
		}
		else {
			request.setAttribute("pan", pan);
		chain.doFilter(request, response);
		System.out.println("bye from filer");
	}
	}
	
	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
