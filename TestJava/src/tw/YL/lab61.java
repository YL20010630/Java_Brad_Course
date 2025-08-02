package tw.YL;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class lab61 {
	
	/*
 		用戶端程式，負責傳送文字訊息到伺服器
	 */

	public static void main(String[] args) {
		String msg = "Hello, World, 61";
		try {
//			Socket socket = new Socket(InetAddress.getByName("www.iii.org.tw"), 0);
			Socket socket = new Socket(InetAddress.getByName("10.0.101.254"), 9999);
//			嘗試連線到伺服器 10.0.101.254，port 9999
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
//			取得 socket 的輸出串流，用 PrintWriter 包起來，方便輸出文字
			
			pw.append(msg);
			pw.flush();
			pw.close();
			
			socket.close();
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}