package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
	 顯示結果＋保留輸入欄位（因為有把表單 HTML 印出來）
 */

@WebServlet("/lab06")
public class lab06 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String x, y, result, op;
		result = "";
		
		
//		取得使用者輸入，對應兩個input
		x = request.getParameter("x");
		y = request.getParameter("y");
		op = request.getParameter("op");
		result = "";
		
		
//		使用者輸入非數字，故用try-catch抓錯誤
		try {
//		轉換成數字
			int intX = Integer.parseInt(x);
			int intY = Integer.parseInt(y);
			
			switch (op) {
			case "1" : result = intX + intY + ""; break;
			case "2" : result = intX - intY + ""; break;
			case "3" : result = intX * intY + ""; break;
			case "4" : result = (intX / intY) + "..." + (intX % intY) + ""; break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + op);
			}
			
			
			
		} catch (Exception e) {
			x = y = op = "";
			System.out.println(e);
		}
		
		
		
//		-------------------
//		輸出到網頁
		response.setContentType("text/html; chasrset=utf-8");
		PrintWriter out = response.getWriter();
		out.printf("<!DOCTYPE html>\n")
			.printf("<html>\n")
			.printf("<head>\n")
			.printf("<meta charset='UTF-8'>\n")
			.printf("<title>Insert title here</title>\n")
			.printf("</head>\n")
			.printf("<body>\n")
			.printf("<form action='lab06'>\n")
			.printf("<input name = 'x' value = '%s' />\n", x)
			.printf("<select name = 'op'>\n")
//			selected 預設選項
			.printf("<option value = '1' %s>＋</option>\n", op.equals("1")?"selected": "")
			.printf("<option value = '2' %s>－</option>\n", op.equals("2")?"selected": "")
			.printf("<option value = '3' %s>×</option>\n", op.equals("3")?"selected": "")
			.printf("<option value = '4' %s>÷</option>\n", op.equals("4")?"selected": "")
			.printf("</select>\n")
			.printf("<input name = 'y' value = '%s' />\n", y)
			.printf("<input type = 'submit' value = '=' />\n")
			.printf("<span>%s</span>\n", result)
			.printf("</form>\n")
			.printf("</body>\n")
			.printf("</html>\n");
		response.flushBuffer();
			
		
		
		
	}

	
}
