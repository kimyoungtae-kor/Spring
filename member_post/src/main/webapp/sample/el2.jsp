<%@page import="vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
/* 	session.invalidate(); */
	%>
	<h2>${member}</h2>
	<h2>${member.id}</h2>
	<h2>${member.getId()}</h2>
	<h2>${member.name.substring(1,2)}</h2>
	<h2>${member.getName()}</h2>
	<h2>${member.email}</h2>
	<h2>${member.num}</h2>
	<h2>${sessionScope.number}</h2>
	<h2>${requestScope.number}</h2>
	<h2>${pageScope.number}</h2>
	<h2>applicationScope::${applicationScope.number}</h2>
		<h2>${number2}</h2>
		
		<h2>${cookie.layer.value}</h2>
	    <h2>cookie : ${cookie['remember-id'].value}</h2>	
	
</body>
</html>