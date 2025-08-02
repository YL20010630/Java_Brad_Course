<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println(request.getMethod());

	// 限制lab34.jsp只能用method post，否則出現405錯誤
	if (!request.getMethod().equals("POST")) response.sendError(405, "錯誤");
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab35.jsp</title>
	</head>
	<body>
		Account: ${param.account }<br />
		Habit: <br />
		1. ${paramValues.habit[0] }<br />
		2. ${paramValues.habit[1] }<br />
		3. ${paramValues.habit[2] }<br />
		4. ${paramValues.habit[3] }<br />
		5. ${paramValues.habit[4] }<br />
		6. ${paramValues.habit[5] }<br />		
	</body>
</html>