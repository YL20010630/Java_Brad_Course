<%@page import="java.util.SortedMap"%>
<%@page import="jakarta.servlet.jsp.jstl.sql.Result"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="tw.lab.apis.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<%-- checkAccount.jsp      連結login.html、main.jsp、logout.jsp --%>


<%-- 如果沒有帳號，則重新導向login頁面 --%>
<c:if test="${empty param.account }">
	<c:redirect url="login.html"></c:redirect>
</c:if>

<sql:query var="rs" dataSource="jdbc/mysql">
	SELECT * FROM member WHERE account = ?
	<sql:param>${param.account }</sql:param>
</sql:query>	

<%-- 如果有帳號，則重新導向login頁面 --%>
<c:if test="${rs.rowCount == 0 }">
	<c:redirect url="login.html"></c:redirect>
</c:if>

<c:choose>
	<c:when test="${BCrypt.checkpw(param.passwd, rs.rows[0].passwd) }">
		<%
			Result result = (Result)pageContext.getAttribute("rs");
			SortedMap[] data = result.getRows();
			SortedMap memberMap = data[0];
		
			Member member = new Member();
			member.setId((long)memberMap.get("id"));
			member.setAccount((String)memberMap.get("account"));
			member.setName((String)memberMap.get("name"));
			
			
			session.setAttribute("member", member);
		%>
		<c:redirect url="main.jsp"></c:redirect>
	</c:when>
	<c:otherwise>
		<c:redirect url="login.html"></c:redirect>
	</c:otherwise>
</c:choose>