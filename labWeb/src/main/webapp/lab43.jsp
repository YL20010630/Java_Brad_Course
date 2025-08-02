<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String[] names = {"Alicia", "Berica", "Celyn", "Deric" };
	pageContext.setAttribute("names", names);
%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab43.jsp</title>
	</head>
	<body>
		<table width="100%" border="1">
			<tr>
				<th>Index</th>
				<th>Count</th>
				<th>Name</th>
				<th>First</th>
				<th>Last</th>
				<th>Current</th>
			</tr>
			
			<!-- 在迴圈中存取目前的狀態資訊 -->
			<c:forEach items="${names }" var="name" varStatus="status">
				<tr>
					<td>${status.index }</td>		
					<td>${status.count }</td>
					<td>${name }</td>
					<td>${status.first }</td>
					<td>${status.last }</td>
					
					<td>${status.current }</td>
				</tr>
				
				<!-- 
					status.index	目前是第幾筆（從 0 開始）
					status.count	目前是第幾筆（從 1 開始）
					status.first	是否是第一筆（true / false）
					status.last		是否是最後一筆（true / false）
					status.current	當前的值（等於 item）
				 -->
				
			</c:forEach>
		</table>
	
		
	</body>
</html>