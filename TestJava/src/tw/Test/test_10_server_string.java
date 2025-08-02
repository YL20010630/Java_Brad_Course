package tw.Test;

import java.io.BufferedInputStream;		// 還是位元組，只能用read()一個個讀位元，跟BufferedReader很像
import java.io.BufferedOutputStream;	
import java.io.BufferedReader;			// 可讀整行文字的緩衝區 ，可用readLine()，跟BufferedInOutputStream很像
import java.io.FileOutputStream;
import java.io.InputStream;				// 取得位元組串流
import java.io.InputStreamReader;		// 位元組串流 轉 字元串流
import java.io.OutputStream;			// 取得輸出串流
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class test_10_server_string {

	public static void main(String[] args) {
		
		
//		傳文字
		try {
//			創一個伺服器，ServerSocket → 等人來連線，Socket → 跟一個客戶端溝通
			ServerSocket server = new ServerSocket(1111);
			System.out.println("Server已啟動，等待連線中......");
			
			Socket socket = server.accept();
//			accept()會卡住，一直等到有 Client 連進來才繼續往下走，連進來後就回傳一個 Socket，代表跟客戶端建立的連線。
			System.out.println("Client 連線進來了");
			
			String urip = socket.getInetAddress().getHostAddress();
			
//			InputStream in = socket.getInputStream();
////			從 Socket 取得輸入位元組串流，表示「客戶端送來的資料」
//			InputStreamReader ir = new InputStreamReader(in);
////			把位元組串流(byte)轉成字元串流(char)，因為文字是字元比較好處理
//			BufferedReader br = new BufferedReader(ir);
////			包裝一層 buffer，並且可以用 readLine() 方便讀一整行文字
			
//			上面三句可總結成下行
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			透過 socket 的 InputStream 包裝成 BufferedReader，方便一行一行讀文字
			
			
			OutputStream out = socket.getOutputStream();
//			取得 輸出串流，代表要把資料回送給客戶端
			PrintWriter pw = new PrintWriter(out, true);
//			文字型的輸出寫法，true 表示自動 flush，(寫完就直接送，不會卡在 buffer)
			
//			進入迴圈，不斷接收 Client 傳來的文字，印出收到的內容，同時回傳給 Client
			String line;
			while((line = br.readLine()) != null) {
				System.out.println("Server收到: " + line);
				pw.println("回傳: "+ line);
			}
			
//			把文字存進sb緩衝區
//			String line2;
//			StringBuffer sb = new StringBuffer();
//			while ((line2 = br.readLine()) != null) {
//				sb.append(line2+"\n");
//			}
//			System.out.printf("%d : %s", urip, line2);		// 錯誤
//			System.out.printf("%d : %s", urip, sb.toString());
			
			
			socket.close();		// 關閉這個跟客戶端的連線
			server.close();		// 關閉整個伺服器，不再聽任何連線
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			

	}

}
