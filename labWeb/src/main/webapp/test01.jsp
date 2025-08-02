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

<c:if test="${param.action == 'insert' }">
	<sql:update var="insertSQL">
		INSERT INTO cust (cname, tel, birthday) VALUES (?, ?, ?)
    <sql:param>${param.name}</sql:param>
    <sql:param>${param.tel}</sql:param>
    <sql:param>${param.birthday}</sql:param>
	</sql:update>
</c:if>
	
<c:if test="${param.action == 'delete' }">
	<sql:update var="deleteSQL">
		DELETE FROM cust WHERE cname = ? OR id = ?
		<sql:param>${param.name}</sql:param>
		<sql:param>${param.id}</sql:param>
		
	</sql:update>
</c:if>

<c:if test="${param.action == 'update' }">
	<sql:update var="updateSQL">
 		UPDATE cust SET tel = ? WHERE id= ?
	    <sql:param>${param.tel}</sql:param>
	    <sql:param>${param.id}</sql:param>
	</sql:update>
</c:if>

<c:if test="${param.action == 'query' }">
	<sql:query var="querySQL">
 		SELECT * FROM cust WHERE cname = ? OR id = ?
 		<sql:param>${param.name }</sql:param>
 		<sql:param>${param.id }</sql:param>
	</sql:query>
</c:if>





	<sql:query var="allSQL">
		SELECT * FROM cust
	</sql:query>



<c:if test="${not empty err}">
    <div style="color:red">錯誤：${err}</div>
</c:if>




</c:catch>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>test01.jsp</title>
	</head>
	<body>
	
		<form action="test01.jsp" method="post">
			<select name="action">
				<option value="insert">新增 Insert</option>
				<option value="delete">刪除 Delete</option>
				<option value="update" selected>修改 Updata</option>
				<option value="query">查詢 Query</option>
			</select>
			
			<hr />
			Name: <input name="name" /><br />
			Tel: <input name="tel"><br />
			Birthday: <input name="birthday"><br />
			Id(刪除或修改時填): <input name="id"><br />
			
			<input type="submit" value="送出" />
		</form>
		
		<hr />
		
		<h2>會員列表</h2>
		<table width="100%" border="1">
		
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Tel</th>
				<th>Bithday</th>
				
			</tr>
			
			action = ${param.action}<br />
			name = ${param.name}<br />
			Tel = ${param.tel}<br />
			Bithday = ${param.birthday}<br />
			Id = ${param.id}<br />
			
			<c:if test="${param.action == 'query' }">
				<c:forEach items="${querySQL.rows }" var="cust">
					<tr>
						<td>${cust.id }</td>
						<td>${cust.cname }</td>
						<td>${cust.tel }</td>
						<td>${cust.birthday }</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${param.action != 'query' }">
				<c:forEach items="${allSQL.rows }" var="cust">
					<tr>
						<td>${cust.id }</td>
						<td>${cust.cname }</td>
						<td>${cust.tel }</td>
						<td>${cust.birthday }</td>
					</tr>
				</c:forEach>
			</c:if>
			
			
		</table>

		
	</body>
</html>