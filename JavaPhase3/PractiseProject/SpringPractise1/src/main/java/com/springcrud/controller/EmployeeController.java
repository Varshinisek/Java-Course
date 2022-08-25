package com.springcrud.controller;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.springcrud.beans.Employee;
import com.springcrud.dao.EmployeeDao;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao dao;
	@RequestMapping(value="/Searchid",  method=RequestMethod.GET)
	public String Search(Model m,@RequestParam(value="id" ,required=false)Integer eid) {
		List<Employee> employeeList=dao.getEmployeeDetails(eid);
		m.addAttribute("employeeList", employeeList);
	if(employeeList.isEmpty()) 
		return "redirect:/invalid";
	else
		 return "Searchid";
	}
	
	@RequestMapping(value="/empform",  method=RequestMethod.GET)
	public String showForm(Model m){
		m.addAttribute("emp", new Employee());
		//System.out.println("show Form");
		return "empform";
		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@ModelAttribute("emp")Employee emp){
		//System.out.println(emp.getEid());
		dao.insert(emp);
		return "redirect:/viewemp";
	}
	@RequestMapping("/viewemp")
	public String viewemp(Model m){
		List<Employee> empList= dao.getEmployeesDetails();
		/*for(Employee e : empList){
			System.out.println(e.getEid());
		}*/
		m.addAttribute("empList",empList);
		return "viewemp";
	}
	
	@RequestMapping(value="/editemp/{eid}")
	public String edit(@PathVariable int eid, Model m){
		
		Employee emp=dao.getEmpId(eid);
		m.addAttribute("emp",emp);
		return "empeditform";
	}
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public String editSave(@ModelAttribute("emp") Employee emp){
		
		System.out.println(emp.getEid());
		dao.update(emp);
		return "redirect:/viewemp";
	}
	
	
	
	
	@RequestMapping(value="/deleteemp/{eid}")
	public String delete(@PathVariable int eid){
		dao.delete(eid);
		return "redirect:/viewemp";
	}	
	
	@RequestMapping("/invalid")
	public void invalid(HttpServletRequest request,ModelMap map, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/index.jsp").include(request, response);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<p style=font-size:18px;color:red;>Oops!!No records found</p>");				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}

	