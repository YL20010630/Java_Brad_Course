<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.lab.apis.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  



<%-- lab54.jsp --%>

<c:catch var="err">
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost/north"
		user="root"
		password="root"
	/>
	<sql:query var="rs">
		SELECT * FROM orders o
		JOIN customers c ON (o.CustomerID = c.CustomerID)
		JOIN employees e ON (o.EmployeeID = e.EmployeeID)
		JOIN orderdetails od ON (o.OrderID = od.OrderID)
		JOIN products p ON (od.ProductID = p.ProductID)
		WHERE o.OrderID = ?
		<sql:param>${param.orderId }</sql:param>
	</sql:query>
	
	<%-- 物件轉字串 --%>
	<%-- 把 SQL 結果 rs.rows 傳入 Java 函式處理，並將多筆 SortedMap<String,String> 轉成一份 JSON 字串 --%>
	${labUtils.order2JSON(rs.rows) }
</c:catch>
${err }

