package tw.YL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import tw.apis.Bike;

public class JDBC15 {
	
	/*
		從 MySQL 資料庫中取出某個會員（member）的 bike 欄位（儲存的 Java 物件），並還原成 Java 的 Bike 物件使用
	 */
	
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = "SELECT * FROM member WHERE id = ?";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try (Connection conn = DriverManager.getConnection(URL, prop);){
			
			PreparedStatement pstmt = conn.prepareStatement(querySQL);
			pstmt.setInt(1, 1);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
//			從資料庫欄位 "bike" 中取得一個物件（Object），然後判斷這個物件是不是 Bike 類別的實體
//			Object obj2 = rs.getObject("bike");
//			if (obj2 instanceof Bike) {
//				System.out.println("Y");
//			}else {
//				System.out.println("N");
//			}
			
			
			InputStream in = rs.getBinaryStream("bike");
			ObjectInputStream oin = new ObjectInputStream(in);
			Object obj = oin.readObject();
			Bike bike = (Bike)obj;
			System.out.println(bike);

			oin.close();
			
			
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}