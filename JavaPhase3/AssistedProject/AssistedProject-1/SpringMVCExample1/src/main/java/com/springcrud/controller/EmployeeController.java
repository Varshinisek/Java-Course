package com.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springcrud.beans.Employee;
import com.springcrud.dao.EmployeeDao;
@Controller
public class EmployeeController {
@Autowired
	EmployeeDao dao;




 @RequestMapping("/viewemp")
 public String viewemp(Model model) {
	 
	 List<Employee>empList =dao.getEmployeesDetails();
	 
	 model.addAttribute("empList",empList);
	return "viewemp";
	 
 }
	
}
