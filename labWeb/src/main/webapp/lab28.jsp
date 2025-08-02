<%@ page import = "tw.lab.apis.Bike" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Bike bike = new Bike();
	bike.upSpeed().upSpeed().upSpeed().upSpeed().upSpeed().upSpeed();
	request.setAttribute("bike", bike);
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab28.jsp</title>
	</head>
	<body>
	lab28.jsp
	<jsp:forward page="lab29.jsp"></jsp:forward>
	
	<!-- forward直接跳轉該頁面，不執行原頁面 -->

		
	</body>
</html>