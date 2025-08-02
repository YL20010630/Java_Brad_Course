package tw.YL;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class lab67 {
	
	/*
		利用 pdfmyurl.com 服務，把 PChome 首頁轉成 PDF
		，並且下載該 PDF 存到 dir2/momo.pdf
	 */

	public static void main(String[] args) {
		String target = "https://www.gamer.com.tw";		// 要換網址就改這裡
		try {
//			URL url = new URL("https://pdfmyurl.com/index.php?url=https://www.pchome.com.tw");
			URL url = new URL(String.format("https://pdfmyurl.com/index.php?url=%s", target));
//			目標網站可替換，透過target把%s塞進去
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
//			透過 pdfmyurl.com 這種服務，請它把 https://www.pchome.com.tw 轉成 PDF
//			pdfmyurl.com 的介面就是把目標網址當成參數送進去
//			建立 HTTPS 連線
//			因為 pdfmyurl 是 https，所以要轉型成 HttpsURLConnection
			
			conn.setRequestMethod("POST");
//			告訴HTTP連線 你要用什麼請求方法，GET是抓資料，POST是送表單資料
			conn.setConnectTimeout(3*1000);		// 3秒還連不上就放棄，避免程式卡住
			conn.setReadTimeout(3*1000);		// 3秒沒讀到資料就放棄
//			conn.connect();			// 呼叫connect()
			
			BufferedInputStream bin = 
				new BufferedInputStream(conn.getInputStream());
//			透過連線拿到輸入串流，因為PDF 是二進位檔案，所以用 BufferedInputStream 來讀二進位資料，
			BufferedOutputStream bout = 
				new BufferedOutputStream(new FileOutputStream("dir2/momo.pdf"));
//			打開一個二進位輸出的串流，再用 BufferedOutputStream 寫到 dir2/momo.pdf，把下載的PDF存成 dir2/momo.pdf
//			，要先確認 dir2 目錄已經存在，否則會拋出 FileNotFoundException
			
			byte[] buf = new byte[4*1024]; int len; int i= 0;
			while ((len = bin.read(buf)) != -1) {
//			每次讀到多少資料就存在len裡面
				bout.write(buf, 0, len);
			}
//			利用緩衝區buf反覆讀寫搬運資料，把PDF內容完整地寫到本地端
			
			bout.flush();
			bout.close();
			bin.close();
			
			System.out.println("Finish");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}