<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage = "true"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Edit Employee Information </h1>
<div style="border:3px solid black;width:25%;border-radius:20px;padding:20px" align="center">
<form:form method="post" action="../editsave" modelAttribute="emp">
       Id  : <form:hidden path="eid"/> <br>
       Name: <form:input path="name" /> <br>
Designation: <form:input path="designation"/> <br>
     Salary: <form:input path="salary"/> <br>
<input type="submit" value="Save changes">
</form:form>
</body>
</html>