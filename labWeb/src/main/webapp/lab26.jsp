<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("lottery", (int)(Math.random()*49+1));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab26.jsp</title>
	</head>
	<body>
		<div>Hello,World</div>
		<hr />
		<jsp:include page="lab27.jsp">
			<jsp:param value="10" name="x"/>
			<jsp:param value="3" name="y"/>
		</jsp:include>
		<hr />
		<div>Footer</div>		
	</body>
</html>