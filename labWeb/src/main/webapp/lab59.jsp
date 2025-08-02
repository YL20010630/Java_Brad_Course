<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib tagdir="/WEB-INF/tags" prefix="lab" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab59.jsp</title>
	</head>
	<body>
		<h1>Lab Big Company</h1>
		<hr />
		<lab:test1 /><br />
		<lab:test2 /><br />
		<lab:test3 /><br />
		<hr />
		<table width="100%" border="1">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<lab:test4 pname="mouse" price="1000" />
			<lab:test4 pname="ps" price="20,000" />
			<lab:test4 pname="keyboard" price="2000" />
		</table>
		
	</body>
</html>