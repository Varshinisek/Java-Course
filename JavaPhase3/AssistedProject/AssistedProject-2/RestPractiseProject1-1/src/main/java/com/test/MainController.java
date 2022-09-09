package com.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/courseinfo")
	public Course getcourse() {
		Course course = new Course();
	    course.setCourseid(1);
	    course.setCoursename("java");
	    course.setFees(400);
	    course.setDurations(9);
	    return course;
		}}
