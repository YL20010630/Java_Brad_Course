<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab41.jsp</title>
	</head>
	<body>
		
		<c:set var="x" value="10"></c:set>
		x = ${x }<br />
		<c:set var="x" value="123" scope="request"></c:set>
		x = ${pageScope.x }<br />
		x = ${requestScope.x }<br />
		<c:set var="y">777</c:set>
		y = ${y }<br />
		<hr />
		<c:out value="Hello, World"></c:out><br />
		
		<!--  若在網址尾端寫?x=Brad，下面兩行x值會變Brad -->
		param.x = ${param.x }<br />
		param.x = <c:out value="${param.x }" default="OK"></c:out>
		<hr />
		
		<jsp:useBean id="member" class="tw.lab.apis.Member"></jsp:useBean>
		<c:set target="${member }" property="id">2</c:set>
		<c:set target="${member }" property="account">Fauna</c:set>
		<c:set target="${member }" property="name">法娜</c:set>
		${member.id } : ${member.account } : ${member.name }<br />
		${member }<br />
		<c:remove var="member"/>
		${member }<br />
		<!-- 直接輸出 ${member} 會呼叫物件的 toString() 方法 -->
		
		
	</body>
</html>