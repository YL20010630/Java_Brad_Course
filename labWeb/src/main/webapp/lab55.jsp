<%@ page import="tw.lab.apis.Bike" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int x = (int)(Math.random()*49+1);
	session.setAttribute("x", x);
	pageContext.setAttribute("y", x);
	request.setAttribute("z", x);		// include or forward
	
	// x = 100;
	
	// 10秒後session失效
	// session.setMaxInactiveInterval(3);
	
	int[] a1 = {1,2,3,4};
	session.setAttribute("a1", a1);
	a1[2] = 100;
	Bike b1 = new Bike();
	b1.upSpeed().upSpeed().upSpeed().upSpeed().upSpeed().upSpeed().upSpeed().upSpeed();
	session.setAttribute("b1", b1);
	
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab55.jsp<</title>
	</head>
	<body>
		lab55.jsp<hr />
		x = ${x };<br />
		y = ${y };<br />
		z = ${z };<br />
		b1 = ${b1 }<br />
		<%
			b1.upSpeed().upSpeed().upSpeed().upSpeed();
		%>
		
		<a href="lab56.jsp">lab56.jsp 超連結</a>
		<!-- 重新導向（新請求），不是 forward，所以只有 session 的 x 會保留，
			request 和 pageContext 都會消失 -->
		
		
	</body>
</html>