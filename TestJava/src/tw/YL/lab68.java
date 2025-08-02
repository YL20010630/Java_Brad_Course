package tw.YL;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class lab68 {
	
	/*
		向農委會開放資料平台請求 JSON，下載並解析印出
		先建立HTTP連線，讀JSON，解析JSON，印出每筆店家資訊
	 */

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx");
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
//			System.out.println(sb);
			
			parseJSON(sb.toString());		// 呼叫 parseJSON 解析 JSON

			System.out.println("Finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);		// 把收到的 JSON 轉成 JSONArray
		System.out.println(root.length());
		for(int i = 0; i<root.length();i++) {
			JSONObject row = root.getJSONObject(i);		// 從陣列裡取出i筆資料放進row
			String name = row.getString("Name");
			String addr = row.getString("Address");
			String tel = row.getString("Tel");
			String city = row.getString("City");
			String town = row.getString("Town");
			System.out.printf("%s : %s : %s%s%s\n", name, tel, city, town, addr);
		}
	}
	
	

}