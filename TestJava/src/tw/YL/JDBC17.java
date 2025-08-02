package tw.YL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JDBC17 {
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = """
											SELECT * FROM gift
											
											""";
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
	try (Connection conn = DriverManager.getConnection(URL, prop);){
			PreparedStatement pstmt = conn.prepareStatement(querySQL,
					
//					可捲動（scrollable）且會感知資料庫變化（sensitive）
					ResultSet.TYPE_SCROLL_SENSITIVE,
//					你可以直接修改 ResultSet 裡的資料，並同步回資料庫
					ResultSet.CONCUR_UPDATABLE
					);
			ResultSet rs = pstmt.executeQuery();
			rs.next();			// 滑鼠移到第一筆資料的意思
			System.out.println(rs.getString("name"));		// 這裡只抓第一筆的名字
			rs.absolute(4);		// 滑鼠移到第四筆資料
			System.out.println(rs.getString("name"));
			rs.first();
			System.out.println(rs.getString("name"));
			rs.last();
			System.out.println(rs.getString("name"));
			rs.absolute(8);
			rs.updateString("feature", "很好喝");
			rs.updateString("tel", "0800-000-123");
			rs.updateRow();		// 執行更新\
			rs.absolute(1);		// 滑鼠移到第四筆資料
			System.out.println(rs.getString("name"));
			rs.absolute(4);		// 滑鼠移到第四筆資料
			System.out.println(rs.getString("feature"));
			rs.absolute(10);
//			rs.deleteRow();		// 刪除id10的行列
			System.out.println("-----");
			System.out.println(rs.getString("name"));		// 這裡印出id9的名字
			rs.moveToInsertRow();		// 滑鼠移到新增資料列
			rs.updateString("name", "Brad禮盒");
			rs.updateString("feature", "送禮自用兩相宜");
//			rs.insertRow();		// 新增到最後一行
			rs.last();
//			rs.deleteRow();
			
			
			System.out.println("OK");
			
			
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}

		
		
	}

}
