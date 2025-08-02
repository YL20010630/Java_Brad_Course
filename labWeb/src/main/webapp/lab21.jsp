<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	if (name == null) name = "Hello, World";
	TreeSet<Integer> Lottery = new TreeSet<>();
	while (Lottery.size() < 6){
		Lottery.add((int)(Math.random()*49+1));
	}
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab21.jsp</title>
	</head>
	<body>
		<div>Hello, <% out.print(name); %></div>	
		<div>Lottery: <% out.print((int)(Math.random()*49+1)); %></div>
		<div>Lottery: <%= (int)(Math.random()*49+1) %></div>
		<hr />
		<div><%= Lottery %></div>		
	</body>
</html>