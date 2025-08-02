<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>    
<c:catch var="err">
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/lab"
		user="root"
		password="root"
	/>	
<%-- 
	<sql:update var="n">
		UPDATE cust SET cname = ?, tel = ? WHERE id = ?
		<sql:param>Fauna</sql:param> 
		<sql:param>789</sql:param> 
		<sql:param>16</sql:param> 
	</sql:update>
--%>


	<%-- 使用外部輸入參數(表單或網址)取得值 --%>
	<sql:update var="n">
		UPDATE cust SET cname = ?, tel = ? WHERE id = ?
		<sql:param>${param.cname }</sql:param>
		<sql:param>${param.tel }</sql:param>
		<sql:param>${param.id }</sql:param>
	</sql:update>

	
	
</c:catch>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab48.jsp</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${n > 0 }">Success</c:when>
			<c:otherwise>Failure</c:otherwise>
		</c:choose>
		
	</body>
</html>