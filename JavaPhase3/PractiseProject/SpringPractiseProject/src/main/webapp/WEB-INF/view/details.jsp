<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Product details page</h3>
<c:set var="product" value="${obj }"></c:set>
Id:${product.id }<br>
Name:${product.name}<br>
Price:${product.price}<br><br>
<a href="update.jsp">Click here to update the project</a><br><br>
<a href="index.jsp">CLick here to go to home page</a>

</body>
</html>