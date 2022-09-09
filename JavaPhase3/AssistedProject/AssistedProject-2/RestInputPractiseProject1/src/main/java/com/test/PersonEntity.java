package com.test;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PersonEntity {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer courseid;
 private String coursename;
	@Column
 private int fees;
 private int durations;
public PersonEntity() {
	super();
	// TODO Auto-generated constructor stub
}
public PersonEntity(Integer courseid, String coursename, int fees, int durations) {
	super();
	this.courseid = courseid;
	this.coursename = coursename;
	this.fees = fees;
	this.durations = durations;
}
public Integer getCourseid() {
	return courseid;
}
public void setCourseid(Integer courseid) {
	this.courseid = courseid;
}
public String getCoursename() {
	return coursename;
}
public void setCoursename(String coursename) {
	this.coursename = coursename;
}
public int getFees() {
	return fees;
}
public void setFees(int fees) {
	this.fees = fees;
}
public int getDurations() {
	return durations;
}
public void setDurations(int durations) {
	this.durations = durations;
}

}