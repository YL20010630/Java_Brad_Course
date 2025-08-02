<%@page import="tw.lab.apis.Bike"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Bike bike = (Bike)request.getAttribute("bike");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab29.jsp</title>
	</head>
	<body>
		<%= bike %>
		<%-- 等於印出bike，out.print(bike) --%>
	</body>
</html>