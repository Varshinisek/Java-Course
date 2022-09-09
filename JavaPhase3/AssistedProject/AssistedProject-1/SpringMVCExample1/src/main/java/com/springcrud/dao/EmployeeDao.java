package com.springcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.springcrud.beans.Employee;
@Component
public class EmployeeDao {
     @Autowired
	JdbcTemplate template;
     public List<Employee> getEmployeesDetails(){
 		String sql="select * from Employee";
 		List<Employee>empList=template.query(sql,new EmployeeMapper());
 		return empList;
 	}
 	
 	
 	
 } 
     