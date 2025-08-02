<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 若是頁面錯誤則跳轉至lab23.jsp --%>
<%@ page errorPage="lab23.jsp" %>
<%
	String id = request.getParameter("id");
	char gender = id.charAt(1);

%>
    
   	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab22.jsp</title>
	</head>
	<body>
	
	
	<!-- 在網址尾端加上?id=123xxx(隨機英數字)即可程式呈現lab22.jsp的頁面而不是23 -->
		lab22.jsp
	</body>
</html>