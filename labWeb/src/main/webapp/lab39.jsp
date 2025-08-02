<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 讓全網站共用一個變數 a，每次有人刷新頁面就 +1，然後顯示出來 --%>
    
<%
	int a = 0;
	application.setAttribute("a", a);	// int => auto-boxing => Integer
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab39.jsp</title>
	</head>
	<body>
		a = ${a }
	</body>
