package tw.YL;

import tw.apis.Member;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.apis.BCrypt;

public class JDBC12 {
	
	/*
		上傳Icon頭像
	 */
	
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String updateSQL = "UPDATE member SET icon = ? WHERE id = ?";

	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (FileInputStream fin = new FileInputStream("dir3/ball.png")) {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
			
//			BinaryStream二進制串流，1是icon欄位
			pstmt.setBinaryStream(1, fin);
			
//			第2個問號（?）的位置為整數值 1，指定要更新的那一筆 id = 1 的會員資料
			pstmt.setInt(2, 1);
			
			pstmt.executeUpdate();
			
//			查詢才需要
//			ResultSet rs = pstmt.executeQuery();
//			rs.next();
			
			System.out.println("OK");

		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

}