<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.lab.apis.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   

<%-- 從農委會的 API 讀取美食資料 → 解析 JSON → 存入資料庫 food 表格中。 --%>
  
 
<c:catch var="err">
	<!-- https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx  -->
	<c:import url="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx" var="data"></c:import>
	
	<c:set var="foods" value="${labUtils.parseFood(data) }"></c:set>
	
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/lab"
		user="root"
		password="root"
	/>
	
	<%-- 清空表格避免重複 --%>
	<sql:update>DELETE FROM food</sql:update>
	<%-- 把 ID 重設成從 1 開始 --%>
	<sql:update>ALTER TABLE food AUTO_INCREMENT = 1</sql:update>
	
	<c:forEach items="${foods }" var="food">
		<sql:update>
			INSERT INTO food (name, tel,addr) VALUES (?,?,?)
			<sql:param>${food.name }</sql:param>
			<sql:param>${food.tel }</sql:param>
			<sql:param>${food.addr }</sql:param>
		</sql:update>
	</c:forEach>

</c:catch>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab49.jsp</title>
	</head>
	<body>
		<c:choose>
			<%-- 清如果有錯誤，顯示<c:catch> 抓的錯誤訊息 --%>
			<c:when test="${!empty err }">${err }</c:when>
			<c:otherwise>Finish</c:otherwise>
		</c:choose>
	</body>
</html>