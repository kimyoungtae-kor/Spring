<%@page import="lombok.EqualsAndHashCode.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"
	%>
	<h1>outer.jsp</h1>
	
	<%
		String num2 = request.getParameter("num");
	%>
	<h1>outer : <%= num2 %></h1>
	<%
		response.sendRedirect("https://www.google.com");
	%>
	
</body>
</html>