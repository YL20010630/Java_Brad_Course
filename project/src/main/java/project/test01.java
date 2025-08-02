package tw.lab.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


/*
	銷售排行榜
 */


@WebServlet("/test01")
public class test01 extends HttpServlet {
	private static Connection conn = null;
     
    public test01() {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "root");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/lab", prop);
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer();
		sb.append("<h1>Lab Big Company</h1>");
		sb.append("<hr />");
		sb.append("<table width='100%' border='1'>");
		sb.append("<tr>");
		sb.append("<th>ID</th><th>Name</th><th>Addr</th><th>Tel</th>");
		sb.append("</tr>");
		
		try {
			String sql = "SELECT p.ProductName, od.UnitPrice, od.Quantity, SUM(od.UnitPrice*od.Quantity) AS TotalSales FROM `orderdetails` od\r\n"
					+ "JOIN products p ON od.ProductID = p.ProductID\r\n"
					+ "GROUP BY p.ProductName\r\n"
					+ "ORDER BY TotalSales DESC";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sb.append("<tr>");
				String id = rs.getString("id");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				String tel = rs.getString("tel");
				sb.append(String.format("<td>%s</td>", id));
				sb.append(String.format("<td>%s</td>", name));
				sb.append(String.format("<td>%s</td>", addr));
				sb.append(String.format("<td>%s</td>", tel));
				sb.append("</tr>");
			}
		}catch(Exception e) {
			
		}
		
		sb.append("</table>");
		
		out.print(sb.toString());
		response.flushBuffer();
		
	}



}
