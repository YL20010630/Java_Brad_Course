package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
	接收使用者從表單（form）送出的註冊資訊
 */

@WebServlet("/lab07")
public class lab07 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String[] interests = request.getParameterValues("interest");
		System.out.printf("%s : %s : %s\n", account, passwd, name);
		if (interests != null) {
			for (String interest: interests) {
				System.out.println(interest);
			}
		}else {
			System.out.println("NO");
		}
		
		
		
	}

}
