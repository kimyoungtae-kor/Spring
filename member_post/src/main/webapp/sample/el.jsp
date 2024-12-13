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
		Member member = Member.builder().id("javaman").name("자바맨").build();
		System.out.println(page == this);
		pageContext.setAttribute("member", member);
			
		pageContext.setAttribute("number", 11);
		request.setAttribute("number", 22);
		session.setAttribute("number",33);

		application.setAttribute("number", 40);
	%>
	<h2>${member}</h2>
	<h2>${member.id}</h2>
	<h2>${member.getId()}</h2>
	<h2>${member.name.substring(1,2)}</h2>
	<h2>${member.getName()}</h2>
	<h2>${member.email}</h2>
		<h2>${member.num}</h2>
		
		<jsp:forward page="el2.jsp"></jsp:forward>
	<%
		response.sendRedirect("el2.jsp");
	%>
</body>
</html>