package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.lab.apis.labUtils;

import java.io.IOException;

/*
	view1
*/

@WebServlet("/lab18")
public class lab18 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		String result = (String)request.getAttribute("result");
		
		try {
//			labUtils.loadView()：將 HTML 檔案讀成文字
			String webContent = labUtils.loadView();
			response.getWriter().print(String.format(webContent, x, y, result));
			response.flushBuffer();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}