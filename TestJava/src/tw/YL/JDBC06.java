package tw.YL;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class JDBC06 {


	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
//			建立 HTTPS 連線

			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
//			取得回傳的 JSON 串流，因為是文字格式 (JSON)，所以用 BufferedReader

			String line; StringBuffer sb = new StringBuffer();

//			把 JSON 一行一行讀進 sb
			while ( (line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			conn.disconnect();
			
			System.out.println("Parse......");
			parseJSON(sb.toString());		// 呼叫 parseJSON 解析 JSON

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void parseJSON(String json) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab",prop);) {
			
//			資料庫清空
			String delAllSQL = "DELETE FROM gift";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(delAllSQL);
			
//			寫入資料
			String zeroSQL = "ALTER TABLE gift AUTO_INCREMENT = 1";
			stmt.executeUpdate(zeroSQL);
		
			String sql = "INSERT INTO gift (name, addr, tel, city, town, feature, picurl, lat, lng) " + 
						"VALUE (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			JSONArray root = new JSONArray(json);		// 把收到的 JSON 轉成 JSONArray
			System.out.println(root.length());
			for(int i = 0; i<root.length();i++) {
				JSONObject row = root.getJSONObject(i);		// 從陣列裡取出i筆資料放進row
				String name = row.getString("Name");
				String addr = row.getString("SalePlace");
				String tel = row.getString("ContactTel");
				String city = row.getString("County");
				String town = row.getString("Township");
				
				String feature = row.getString("Feature");
				String picurl = row.getString("Column1");
				
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
				
//				將欄位值放入 SQL 並執行
				pstmt.setString(1, name);
				pstmt.setString(2, addr);
				pstmt.setString(3, tel);
				pstmt.setString(4, city);
				pstmt.setString(5, town);
				pstmt.setString(6, feature);
				pstmt.setString(7, picurl);
				
				try {
					pstmt.setDouble(8, Double.parseDouble(lat));
					pstmt.setDouble(9, Double.parseDouble(lng));					
				} catch (Exception e) {
					pstmt.setDouble(8, 0.0);
					pstmt.setDouble(9, 0.0);	
				}
//				寫入這筆資料到資料庫
				pstmt.executeUpdate();
			}
			System.out.println("Finish");
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}