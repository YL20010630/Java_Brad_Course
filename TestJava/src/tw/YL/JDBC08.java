package tw.YL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC08 {
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final int RPP = 10;
	private static final String SQL = "SELECT * FROM gift ORDER BY id LIMIT ?,?";
//	限制此次查詢結果

	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.println("頁：");
		int page = scaner.nextInt();
		int start = (page - 1)*RPP;		// (頁數 - 1) * 每頁筆數
		
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try(Connection conn = DriverManager.getConnection(URL,prop);) {
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		
//		從0開始10筆資料，10代表一頁有10筆
//		pstmt.setInt(1, 10);
//		pstmt.setInt(2, 20);
//		setInt(1, 10)+setInt(2, 20)代表從第11筆開始查20筆資料
		
		pstmt.setInt(1, start);
		pstmt.setInt(2, RPP);
		
//		pstmt.setInt(1, RPP);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			System.out.printf("%s:%s\n", id, name);
		}
		
		
		}catch(Exception e) {
			System.out.println(e);
		}

	}
}
