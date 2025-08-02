package tw.YL;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC03 {
	
	/*
		新增刪除修改項目
	 */

	public static void main(String[] args) {

//		建立一個 Properties 物件，它是一種 「鍵值對（key-value）」的設定資料結構
		Properties prop = new Properties();

//		建立連線屬性（帳號、密碼）		
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try {
//			建立資料庫連線，prop傳入帳密設定
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab", prop);
			
//			執行 SQL 新增語句
			String sql = "INSERT INTO cust (cname, tel, birthday) VALUE ('Amily', '123' , '2000-12-31')";
//			String sql = "INSERT INTO cust (cname, tel, birthday) VALUE ('Betty', '123' , '2000-12-31')";
//			String sql = "INSERT INTO cust (cname, tel, birthday) VALUE ('Cindy', '123' , '2000-12-31')";
//			String sql = "INSERT INTO cust (cname, tel, birthday) VALUE ('David', '123' , '2000-12-31')";
			
//			Statement是執行 SQL 指令的物件
//			適用於靜態 SQL 語句（內容不會變動）。如果 SQL 中有變數，建議改用 PreparedStatement
			Statement stmt = conn.createStatement();
//			
//			執行並回傳影響筆數
			int n = stmt.executeUpdate(sql);

			
			
//			根據回傳值印出是否成功
			if( n > 0) {
				System.out.println("insert success");
			}else {
				System.out.println("insert failure");
			}
			
//			執行 SQL 刪除與更新
//			System.out.println("--------");
//			String sql = "DELETE FROM cust WHERE id = 12";
//			stmt.executeUpdate(sql);
			
//			System.out.println("--------");
//			String sql = "UPDATE cust SET tel='456', birthday='2001-01-01' WHERE id=12";
//			stmt.executeUpdate(sql);
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

