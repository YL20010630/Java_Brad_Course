package tw.lab.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.lab.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;

/*
	設定請求參數與物件（x, y, bike）
	將請求轉交給另一個 Servlet（lab14）執行
	在前後印出自己的 HTML
	最終合併輸出 HTML 結果
 
 */

@WebServlet("/lab13")
public class lab13 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
//		建立一個「請求轉送」物件，準備把這個 request 交給 lab14 servlet 處理，並附帶 ?name=lab 參數
		RequestDispatcher dispatcher = request.getRequestDispatcher("lab14?name=lab");
//		request.getRequestDispatcher("lab14?name=lab") 只會找 Servlet 路徑 或 相對資源路徑，
//		所以不會印出放在 webapp 目錄下的lab14.html
		
		
//		setAttribute將一個變數或物件放進 request、session 或 application 的範圍中，給其他程式讀取用
//		將兩個變數 x 與 y 放進 request 中，給 lab14 使用
		request.setAttribute("x", 10);
		request.setAttribute("y", 3);
		
		Bike b1 = new Bike();
		b1.upSpeed().upSpeed().upSpeed().upSpeed();
		request.setAttribute("bike", b1);
		
		//-----------------
//		準備輸出 HTML 到瀏覽器
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Lab Big Company</h1>");
		out.println("<hr />");
		out.println("<div>Hello, World, lab13.java</div>");
		
//		引入 lab14.java 的執行結果進來一起輸出(而不是跳轉)，等於中途插播另一支 Servlet 執行的結果到這邊
		dispatcher.include(request, response);
		
//		若是include改為forward，則網頁只會顯示 lab14 的輸出內容（不會有 lab13 的 <h1> 和 <div>），lab13 後面的 out.println(...) 都不會被執行了
		
		
		
		out.println("<hr />");
		response.flushBuffer();
	}



}
