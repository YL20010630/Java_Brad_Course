package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.lab.apis.labUtils;

import java.io.IOException;

/*
	負責載入 view，並產生結果頁面（純 HTML）
	view2, view3
*/


@WebServlet("/lab19")
public class lab19 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x = (String)request.getAttribute("x");
		String y = (String)request.getAttribute("y");
		String result = (String)request.getAttribute("result");
		String view = (String)request.getAttribute("view");
		
		try {
			String webContent = labUtils.loadView(view);
			String content = webContent.replaceAll("#x#", x)
					.replaceAll("#y#", y)
					.replaceAll("#result#", result);
			response.getWriter().print(content);
			
			response.flushBuffer();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}