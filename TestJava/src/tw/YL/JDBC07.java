package tw.YL;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class JDBC07 {
	
	/*
		關鍵字查詢功能，會讓使用者輸入一個關鍵字，
		然後在資料庫的 gift 表格中查詢 name 或 feature 欄位中包含該字串的資料，
		最後將資料顯示出來。
	 */

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab",prop);) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Keyword:");
			String key = scanner.next();
			
//			用 % 包起來，代表 模糊搜尋
			String search = "%" + key + "%";
//			條件是：name 或 feature 有包含關鍵字（LIKE ?）
			String sql = "SELECT id, name, tel, addr, city, town, feature FROM gift " +
						"WHERE name LIKE ? OR feature LIKE ? ORDER BY city, town, addr";
//			用 ORDER BY 排序結果
			
//			建立 PreparedStatement 物件並替代掉 ?
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setString(2, search);
//			把字串 search 的值，設定到 SQL 語句中第一個 ? 的位置
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String feature = rs.getString("feature");
				String city = rs.getString("city");
				String town = rs.getString("town");
				String addr = rs.getString("addr");
				System.out.printf("%s:%s:%s%s%s\n", id, name, city,town,addr);
			}
			
			
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

	}
}
