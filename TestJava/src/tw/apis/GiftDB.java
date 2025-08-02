package tw.apis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

/*
	資料處理
*/

public class GiftDB {
	
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = """
											SELECT id 編號, name 名稱, feature 特色說明, tel 電話, city 縣市 FROM gift
											
											""";
	
	private Connection conn;
	private ResultSet rs;
	private String[] fieldNames;
	
	public GiftDB() throws Exception {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		conn = DriverManager.getConnection(URL, prop);
		
//		呼叫 queryDB() 重新讀資料＋通知表格更新
		queryDB();
	}
	public void queryDB() throws Exception {queryDB(querySQL);}
	public void queryDB(String sql) throws Exception{
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,		// 可以前後移動（捲動）
				ResultSet.CONCUR_UPDATABLE);			// 可以直接更新或刪除資料
		rs = stmt.executeQuery(sql);
		
//		取得查詢結果的欄位名稱
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];		
//		fieldNames欄位名總稱且是陣列[]，rsmd.getColumnCount()欄位數
		
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnLabel(i+1);		// fieldNames[0] = 第(0+1)欄 欄位別名
//			getColumnName()：回傳資料表中的原始欄位名稱（如 id, name），getColumnLabel()：回傳 SQL 結果的別名（如 編號, 名稱）
		}
	}
	
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	
	public int getCols() {
		return fieldNames.length;
	}
	// row, col => 0-base，從0算起
	public String getData(int row, int col) {
		try {
			rs.absolute(row+1);		// row從0算起，.absolute(幾)就是幾
			return rs.getString(col+1);		// 滑鼠移到第row+1行，抓取第col+1欄字串
		}catch(Exception e) {
			return "#ERROR";
		}
	}
	
	public String getColName(int col) {
		return fieldNames[col];		// col跟fieldNames[]陣列都是從0算起，故多少就是多少
	}
	
	public void updateData(int row, int col, String newdata) {
		if (col != 0) {
			try {
				rs.absolute(row+1);					// 游標移到該列
				rs.updateString(col+1, newdata);	// 更新內容
				rs.updateRow();						// 更新進資料庫
			}catch(Exception e) {
				System.out.println(e);
			}
		}
	}
	
	
	public void delData(int row) {
		try {
			rs.absolute(row+1);
			rs.deleteRow();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}