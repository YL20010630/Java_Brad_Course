package tw.YL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC05 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab",prop);) {
//			查詢cust表所有欄位資料 的SQL命令語句
			String sql = "SELECT * FROM cust";
			
//			使用 conn 建立 PreparedStatement 物件，準備執行 SQL 語句。PreparedStatement是執行 SQL 指令的物件
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
//			執行查詢，回傳的結果存在 ResultSet 物件 rs 中
			ResultSet rs = pstmt.executeQuery();
			
//			逐筆讀取 ResultSet 裡的每一行資料
			while (rs.next()) {
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				String tel = rs.getString("tel");
				String birthday = rs.getString("birthday");
				System.out.printf("%s:%s:%s:%s\n", id, cname, tel, birthday);
			}
			
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}
