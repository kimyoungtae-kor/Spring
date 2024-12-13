<%@page import="org.apache.jasper.tagplugins.jstl.core.Choose"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str" value="abcd" scope="request"/>
	<c:set var="str1" value="abcde" scope="page"/>
	<h3>${pageScope.str}</h3>
	<c:if test="${empty pageScope.str}">
		<h3>페이지 스코프에 str이없습니다 :: ${str}</h3>
	</c:if>
	<c:if test="${not empty pageScope.str}">
		<h3>페이지 스코프에 str이있습니다 :: ${pageScope.str1}</h3>
	</c:if>
</body>
</html>