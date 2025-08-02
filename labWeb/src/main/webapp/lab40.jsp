<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 讓全網站共用一個變數 a，每次有人刷新頁面就 +1，然後顯示出來 --%>
    
<%
	Integer a = (Integer)application.getAttribute("a");
	if (a == null){
		application.setAttribute("a", 0);
	}else{
		a++;
		application.setAttribute("a", a);
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab40.jsp</title>
	</head>
	<body>
		a = ${a }
	</body>
