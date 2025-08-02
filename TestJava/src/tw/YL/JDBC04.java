package tw.YL;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC04 {
	
	/*
		從eclipse的console輸入資料
	 */

	public static void main(String[] args) {

		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab",prop);) {
//			建立 Scanner 物件，用來接收使用者從鍵盤輸入的資料
			Scanner scanner = new Scanner(System.in);
			System.out.print("Name:");
			String name = scanner.next();		// scanner.next();輸入字串
			System.out.print("Tel:");
			String tel = scanner.next();
			System.out.print("Birthday:");
			String birthday = scanner.next();
			String sql = "INSERT INTO cust (cname,tel,birthday) VALUES (?,?,?)";
			
//			使用 PreparedStatement 將輸入的資料插入到 cust 資料表中
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			
//			執行並回傳影響筆數
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println("insert success");
			}else {
				System.out.println("insert failure");
			}	
			System.out.printf("新增成功：%s / %s / %s\n", name, tel, birthday);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

