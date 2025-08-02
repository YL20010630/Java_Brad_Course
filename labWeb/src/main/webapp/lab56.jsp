<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	// int x = (Integer)session.setAttribute("x");

	// 如果x沒有了，就返回403錯誤
	Object obj = session.getAttribute("x");
	if (obj == null){
		response.sendError(HttpServletResponse.SC_FORBIDDEN, "權限被拒403");
	}
	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab56.jsp<</title>
	</head>
	<body>
		lab56.jsp<hr />
		x = ${x }<br />
		y = ${y }<br />
		z = ${z }<hr />
		a1[2] = ${a1[2] }<hr />		
		Bike = ${b1 }
		<a href="lab57.jsp">lab57.jsp 超連結</a>
		
	</body>
</html>