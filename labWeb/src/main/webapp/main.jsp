<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<c:if test="${ empty member.account }">
	<c:redirect url="login.html"></c:redirect>
</c:if>    
 
<!DOCTYPE html>
<html>

	<!-- 連結login.html、checkAccount.jsp、logout.jsp -->

	<head>
		<meta charset="UTF-8">
		<title>main.jsp</title>
	</head>
	<body>
		<h1>Main Page</h1>	
		<hr />
		Welcome, ${member.id }:${member.account }:${member.name }<br>
		<img alt="" src="data:image/jpeg; base64, ${member.icon }" />
		<hr />
		<a href="logout.jsp">Logout</a>	
	</body>
</html>