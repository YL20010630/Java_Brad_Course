<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab45.jsp</title>
	</head>
	<body>
		<c:catch var="err">
			<sql:setDataSource
				driver="com.mysql.cj.jdbc.Driver"
				url="jdbc:mysql://localhost/lab"
				user="root"
				password="root"
			/>		
			
			<!-- 把 id 大於等於 9 的所有資料，欄位 cname 改成 zzz -->
			<sql:update var="n1">
				UPDATE cust SET cname = 'zzz' WHERE id >= 31
			</sql:update>
			<sql:update var="n2">
				DELETE FROM cust WHERE id >= 9
			</sql:update>
		</c:catch>
		${err }<br />
		Update: ${n1 }<br />
		Delete: ${n2 }<br />
		
		
	</body>
</html>