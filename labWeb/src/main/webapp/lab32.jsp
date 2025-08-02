<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 
	EL
 --%>
    
    
<%-- 如果已經有 member 存在於作用域，就會拿來用，否則就創建一個新的 --%>
<jsp:useBean id="member" class = "tw.lab.apis.Member"></jsp:useBean>

<%-- 錯誤，setProperty 是 JSP 標籤，jsp:getProperty 只能讀取 <jsp:useBean> 創建的物件，所以不能使用
<jsp:setProperty property="account" value="<%= request.getParameter("account") %>" name="member"/>
<jsp:setProperty property="name" value="<%= request.getParameter("name") %>" name="member"/>
 --%>
 
<jsp:setProperty property="account" value='${param.account }' name="member"/>	
<jsp:setProperty property="name" value='${param.name }' name="member"/>	 
 
<%-- ${} 先轉換再編譯 --%>

<%-- 

			用法類型						寫法									等同於 Java 語法
			useBean				<jsp:useBean id="m" class="...">		Member m = new Member();
			setProperty			<jsp:setProperty ... />					m.setXxx(...)
			getProperty			<jsp:getProperty ... />					m.getXxx()
			EL 基本				${param.name}							request.getParameter("name")
			EL 物件屬性			${member.account}						member.getAccount()

 --%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab32.jsp/title>
	</head>
	<body>
		
		<!-- 用 JSP 標籤 -->
		Member: <jsp:getProperty property="account" name="member"/> :
				<jsp:getProperty property="name" name="member"/><hr />
				
		<!-- 用 Java 輸出 -->
		Member: <%= member.getAccount() %> : <%= member.getName() %><hr />
		
		<!-- 用 EL 表達式 -->
		Member: ${member }<hr />		<!-- 印出toString -->
		
		<!-- EL 表示物件屬性讀取，等同於 member.getAccount()、member.getName() -->
		Member: ${member.account } | ${member.name }<hr />
		
		<!-- EL內建類別 -->
		${Math.random() }<br />
		${Math.PI } 
		
		
		
		
		
		
		
		
		
		
		
	</body>
</html>