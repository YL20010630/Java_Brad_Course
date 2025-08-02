<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  

 

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab50.jsp</title>
	</head>
	<body>
		
		<!-- 一頁有幾筆 -->
		<c:set var="rpp">10</c:set>
		<!-- 目前頁碼 -->
		<c:set var="page">${empty param.page?1:param.page }</c:set>
		<!-- 從第幾筆開始 -->
		<c:set var="start">${(page - 1) * rpp }</c:set>
		<!-- 上一頁 -->
		<c:set var="prev">${page==1?1:page-1 }</c:set>
		<!-- 下一頁 -->
		<c:set var="next">${page+1 }</c:set>
		
		
		<sql:query var="rs" dataSource="jdbc/mysql">
			SELECT * FROM food LIMIT ${start }, ${rpp }
		</sql:query>
		
		<!-- 顯示目前這一頁撈了幾筆資料
		Rows: ${rs.rowCount }  -->
		
		
		<h1>Lab Big Company</h1>
		<hr />

		<!-- 分頁連結 -->
		<a href="?page=${prev }">Prev</a> | Page: ${page } |<a href="?page=${next }">Next</a>
		
		<table width="100%" border="1">
			<tr>
				<th>Id</th><th>Name</th><th>Tel</th><th>Address</th>
			</tr>
			
			<c:forEach items="${rs.rows }" var="food">
			<tr>
				<td>${food.id }</td>
				<td>${food.name }</td>
				<td>${food.tel }</td>
				<td>${food.addr }</td>
			</tr>
			
			</c:forEach>
			
		</table>
		
	</body>
</html>