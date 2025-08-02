<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
//	request.getLocale().getDisplayLanguage();
%>
    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab36.jsp</title>
	</head>
	<body>
		Method: ${pageContext.request.method }<br />
		Locale: ${pageContext.request.locale}<br />
		Language: ${pageContext.request.locale.language }<br />
		
	</body>
</html>