<%@page import="java.util.Enumeration"%>
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
		request.setCharacterEncoding("utf-8");
		String val1 = request.getParameter("value1");
		String val2 = request.getParameter("value2");
		String[] val3 = request.getParameterValues("hobby");
		
		
		Enumeration<String> names = request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println(name + " ::::::::: " + request.getParameter(name));	
		}
		
	%>
		<h2><%=val1 %></h2>
		<h2><%=val2 %></h2>
		<h2><%
		if(val3 !=null){
			for(String hobby : val3){
				out.print(hobby + ", ");
			}
		}
		
			%></h2>
		
		<h2><%=request.getMethod()%></h2>
		
	<h2><% System.out.println(val1); %></h2>
	<h2><% System.out.println(val2); %></h2>


</body>
</html>