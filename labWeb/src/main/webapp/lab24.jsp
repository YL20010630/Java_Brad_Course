
<%--
	連接MemberDB.java、Register.java


 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String mesg = "";
	String errType = request.getParameter("errType");
	if (errType != null){
		switch(errType){
			case "1": mesg = "新增失敗"; break;
			case "2": mesg = "帳號重複"; break;
		}
	}
%>    

   	
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab24.jsp</title>
	</head>
	<body>
		<script>
			function checkForm(){
				
				return true;
			}
		</script>
		<%= mesg %>
		<form action="Register" onsubmit="return checkForm();" method="post">
			Account: <input name="account" /><br />
			Password: <input type="password" name="passwd" /><br />
			Name: <input name="name" /><br />
			<input type="submit" value="Register" />
		</form>
		
	</body>
</html>