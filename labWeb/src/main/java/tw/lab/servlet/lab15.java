package tw.lab.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*
	MVC，Model - View - Controller（模型 - 視圖 - 控制器），面試問題之一
	Model，負責：處理資料邏輯（例如查資料庫、計算），在 Java Web 裡代表：Java 類別（例如 DAO、VO、Service）
	View，負責：負責顯示畫面（例如表單、表格），在 Java Web 裡代表：HTML、JSP、前端頁面
	Controller，負責：接收請求，調度 Model 並傳資料給 View，在 Java Web 裡代表：Servlet
	
	MVC 是為了「分離程式的邏輯與畫面」，讓你：
	程式更好維護
	UI 和邏輯可以分開開發
	功能擴充更清晰明確
	
	JSP代替更快，但比MVC不好維護不好用
	JSP：簡單來說就是可以把「HTML + Java 程式碼」寫在同一個頁面中
 */

@WebServlet("/lab15")
public class lab15 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
//		建立一個轉送器，準備把 request 與 response 轉給 lab16
		RequestDispatcher dispatcher = request.getRequestDispatcher("lab16");
		
		//-----------------
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>labd15.java</h1>");
		
//		這行會直接「跳轉（forward）」到 lab16，而且跳轉後 原本的 out.println() 結果不會顯示出來
		dispatcher.forward(request, response);
	}

}