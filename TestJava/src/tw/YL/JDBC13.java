package tw.YL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC13 {
	
	/*
		抓取已上傳的Icon頭像
	 */
	
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = "SELECT * FROM member WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (FileOutputStream fout = new FileOutputStream("dir1/JDBC13.png");
			Connection conn = DriverManager.getConnection(URL, prop);){
			
			PreparedStatement pstmt = conn.prepareStatement(querySQL);
//			設定第 1 個問號為 1，也就是查詢 id = 1 的會員
			pstmt.setInt(1, 1);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			InputStream in = rs.getBinaryStream("icon");
			byte[] icon = in.readAllBytes();
			fout.write(icon);
			fout.flush();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}