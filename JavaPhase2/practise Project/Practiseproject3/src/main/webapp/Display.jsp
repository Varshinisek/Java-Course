<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h3> Product Details</h3>
ProductId:<%=session.getAttribute("pid")%><br><br>
ProductName:<%= session.getAttribute("productname")%><br><br>
Price:<%=session.getAttribute("price")%><br><br>
Quantity:<%=session.getAttribute("quantity")%><br><br>
</center>
</body>
</html>