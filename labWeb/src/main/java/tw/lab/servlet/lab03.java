package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@WebServlet("/lab03")
public class lab03 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		設定請求的編碼是 UTF-8，通常用來正確處理中文參數
		request.setCharacterEncoding("utf-8");
		
//		 拿到使用者送來的所有Header 名稱列表 Host, User-Agent, Accept...
		Enumeration<String> names = request.getHeaderNames();
		
//		迴圈，只要還有下一個 header，就繼續跑
		while (names.hasMoreElements()) {
			
//			拿出這一個 header 的名稱
			String name = names.nextElement();
//			拿出這個 header 的值
			String value = request.getHeader(name);
//			System.out.println(name);
			System.out.printf("%s : %s \n", name, value);
			
		}
		System.out.println("--------");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
