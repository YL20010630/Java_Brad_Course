package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


//	HttpServletRequest 		用來讀取使用者送來的資料
//	HttpServletResponse 	用來回傳資料給使用者
//	HttpSession 			用來記住登入資訊

@WebServlet("/lab01")
public class lab01 extends HttpServlet {
	
	
//	ServletRequest遠端傳遞的任何東西
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
	

