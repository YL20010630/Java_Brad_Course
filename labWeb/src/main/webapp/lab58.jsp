<%@page import="java.util.Date"%>

<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab58.jsp</title>
	</head>
	<body>
		<%
			Locale locale =  request.getLocale();
			String lang = locale.getLanguage();
			String country = locale.getCountry();
			pageContext.setAttribute("lang", lang+"_"+country);
		%>
		Language = ${lang }<br />
		<fmt:setLocale value="${lang }"/><fmt:setBundle basename="res"/>
		<h1><fmt:message key="companyName" /></h1>
		<hr />
		<fmt:message key="hello" />, <fmt:message key="world" /> 
		<hr />
		<%
			Date now = new Date();
			pageContext.setAttribute("now", now);
			out.print(now);
		%><br />
		<fmt:setTimeZone value="Asia/Taipei" />
		Taiwan: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br />
		<fmt:setTimeZone value="Asia/Tokyo" />
		Japan: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br />
		<fmt:setTimeZone value="Europe/Berlin" />
		German: <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss" /><br />
		<hr />
		<fmt:setLocale value="de"/>
		<fmt:formatNumber value="1234567.1234" type="currency" currencyCode="EUR" />
		
	</body>
</html>