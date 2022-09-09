package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/course")
public class PersonController {
	 @Autowired
	    PersonService personService;
	  
	    
	    @PostMapping(value="/person")   
	    public void addPerson(@RequestBody PersonEntity pe ) {
	        personService.addPerson(pe);
	        System.out.println(pe.getCoursename());
	    }
	}

