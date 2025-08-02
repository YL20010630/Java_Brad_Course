

<%-- 連接Member.java --%>


<%@page import = "tw.lab.apis.Member" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%-- Member1  java寫法 --%>
<%
	Member member1 = new Member();
	member1.setId(1);member1.setAccount("Fenysa");member1.setName("芬妮莎");
%>

<%-- Member2  JSP標籤寫法 --%>
<!-- 下面可等於上面兩行 --> 
<jsp:useBean id="member2" class = "tw.lab.apis.Member"></jsp:useBean>
<jsp:setProperty property="id" value="2" name="member2"/>
<jsp:setProperty property="account" value="Gloria" name="member2"/>
<jsp:setProperty property="name" value="葛羅莉亞" name="member2"/>

<%-- useBean：在 scope 中找不到 member2 時就建立新的物件。等同於Member member2 = new Member(); --%>
<%-- setProperty：自動幫物件呼叫 setter 方法（例如 setId(2)） --%>

<%--
		<!-- Member1無法使用JSP輸出資料，失敗，
			因為 jsp:getProperty 只能讀取 <jsp:useBean> 創建的物件
			
			備註：不知為何這段註解放下面沒辦法跑程式
			 -->	
 --%>

    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>lab30.jsp</title>
	</head>
	<body>
	
		<!-- Member1使用java輸出資料，成功 -->
		Member1: <%= member1.getId() %> : <%= member1.getAccount() %> : <%= member1.getName() %> <br />
		
		<!-- Member2使用JSP輸出資料，成功 -->
		Member2: <jsp:getProperty property="id" name="member2"/> :
				<jsp:getProperty property="account" name="member2"/> :
				<jsp:getProperty property="name" name="member2"/><br />
		<hr />
		
		<!-- Member2使用java輸出資料，成功 -->

		Member2: <%= member2.getId() %> : <%= member2.getAccount() %> : <%= member2.getName() %> <br />



				
				
	</body>
</html>