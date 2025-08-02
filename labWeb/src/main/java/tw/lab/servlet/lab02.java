package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/lab2")
public class lab02 extends HttpServlet {
	
//	lab02：只會在 Servlet 被實例化時出現一次
	public lab02() {
		System.out.println("lab02()");
	}
	
//	Hello, World：每次用瀏覽器重新整理 /lab02 頁面，就會再次出現
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("Hello, World");
    }

}
