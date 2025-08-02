<%@page import="tw.lab.apis.Bike"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	HashMap<String, Object> person = new HashMap<>();
	person.put("name", "Silvia");
	person.put("age", "16");
	person.put("gender", "false");
	Bike bike = new Bike();bike.upSpeed().upSpeed().upSpeed().upSpeed();
	person.put("bike", bike);
	pageContext.setAttribute("person", person);


%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab47.jsp</title>
	</head>
	<body>
		Name: ${person.name }<br />
		Age: ${person.age }<br />
		gender: ${person.gender }<br />
		Bike: ${person.bike }<br />
	</body>
</html>