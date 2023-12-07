<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
<jsp:useBean id="product" class="com.application.jspactions.Product">
</jsp:useBean>
Product Details </br>

Id: <jsp:getProperty property="id" name="product"/><br/>
Name: <jsp:getProperty property="name" name="product"/><br/>
Description: <jsp:getProperty property="description" name="product"/>
Price: <jsp:getProperty property="price" name="product"/>

</body>
</html>