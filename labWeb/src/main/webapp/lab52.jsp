<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%-- 連結lab51.html、labUtils.java --%>
    
<%

//	當前端發來的是POST方法的請求，才會執行裡面的程式
	if(request.getMethod().equals("POST")){		
		try{
//			request.getParameter("max")取得從表單傳來的 max 值
			int max = Integer.parseInt(request.getParameter("max")); 
			out.print((int)(Math.random()*max+1));
			
			
		}catch(Exception e){
			out.print("ERROR: "+ e );
		}
	}


%>