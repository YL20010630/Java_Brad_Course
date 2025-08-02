package tw.YL;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class lab66 {
	
	/*
		連線到 https://www.ispan.com.tw
		把網頁 HTML 原始碼抓下來
		存成 dir1/iii.html
	 */

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.ispan.com.tw");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
//			用 openConnection() 打開連線，並且強制轉型為 HttpsURLConnection（因為是 HTTPS 協定）		
			
			BufferedReader reader = 
				new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
//			透過 conn.getInputStream() 取得伺服器傳回的串流資料（HTML 內容），
//			，並用 BufferedReader 包起來方便一行一行讀。
			
//			URLConnection conn = url.openConnection();
//			if(conn instanceof HttpsURLConnection) {
//				System.out.println("OK");
//				}if(conn instanceof HttpsURLConnection) {
//					System.out.println("OK2");
//				}
			
			String line; StringBuffer sb = new StringBuffer();
			
			// 把讀到的每一行加到 StringBuffer 中
			while ( (line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			conn.disconnect();
//			關掉 reader，並呼叫 conn.disconnect() 結束連線
			
			FileOutputStream fout = new FileOutputStream("dir1/iii.html");
//			把剛剛存好的字串，存成檔案 dir1/iii.html
			fout.write(sb.toString().getBytes());
//			把抓到的網站原始碼寫進去
			fout.close();
			
			
			System.out.println("Finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}