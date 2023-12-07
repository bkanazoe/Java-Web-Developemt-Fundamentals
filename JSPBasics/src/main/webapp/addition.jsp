<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition of two numbers</title>
</head>
<body>
<%--scriplet tag--%>
<%--int num1 = Integer.parseInt(request.getParameter("number1")); --%>
<%-- int num2 = Integer.parseInt(request.getParameter("number2"));--%>
<%
String name = request.getParameter("number1");
%>
<%--expression tag --%>
Sum of <%=name %>

</body>
</html>