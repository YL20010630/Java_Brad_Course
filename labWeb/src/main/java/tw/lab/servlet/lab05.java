package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
	顯示結果後畫面「變成只有純文字」
 */

@WebServlet("/lab05")
public class lab05 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
//		取得使用者輸入，對應兩個input
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
//		轉換成數字
		int intX = Integer.parseInt(x);
		int intY = Integer.parseInt(y);
		int result = intX + intY;
	
//		-------------------
//		輸出到網頁
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("%s + %s = %d", x, y, result);
		response.flushBuffer();
	}
}
