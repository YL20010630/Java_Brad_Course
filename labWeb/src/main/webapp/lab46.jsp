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

	<sql:query var="rs">
		SELECT * FROM gift LIMIT 10
	</sql:query>
	
</c:catch>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab46.jsp</title>
	</head>
	<body>
		資料筆數：${rs.rowCount }<br />
		
		<table width="100%" border="1">
			<tr>
				<th>Name</th>
				<th>Tel</th>
				<th>Addr</th>
				<th>Photo</th>
			</tr>
			<c:forEach items="${rs.rows }" var="gift">
				<tr>
					<td>${gift.name }</td>
					<td>${gift.tel }</td>
					<td>${gift.city }${gift.town }${gift.addr }</td>
					<td><img src="${gift.picurl }" width="160px" height="90px"></td>
				</tr>
			</c:forEach>
		</table>
		
		
		
	</body>
</html>