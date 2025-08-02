<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab44.jsp</title>
	</head>
	<body>
		<c:catch var="err">
			<sql:setDataSource
				driver="com.mysql.cj.jdbc.Driver"
				url="jdbc:mysql://localhost/lab"
				user="root"
				password="root"
			/>
			<sql:update var="n1">
				INSERT INTO cust (cname,tel,birthday) VALUES ('Fauna', '12345', '1999-01-31'),
				('Gloria', '1234', '1999-02-28'),
				('Huna', '5677', '1999-03-30')
		
			</sql:update>
		</c:catch>
		${err }<br />
		Insert: ${n1 }<br />
		
	</body>
</html>