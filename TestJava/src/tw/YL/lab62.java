package tw.YL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class lab62 {
	/*
 		伺服器端程式，負責接收文字訊息並印出
	 */
	public static void main(String[] args) {
		ServerSocket server = null;
		try {
			server = new ServerSocket(9999);
			Socket socket = server.accept();
			
			String urip = socket.getInetAddress().getHostName();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			透過 socket 的 InputStream 包裝成 BufferedReader，方便一行一行讀文字
			
			String line; 
			StringBuffer sb = new StringBuffer();
			while ( (line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
//			持續讀取客戶端送來的訊息，直到對方關閉串流（回傳 null），把每行文字都存進 sb
			
			System.out.printf("%s: %s\n", urip, sb.toString());
			
			socket.close();
//			System.out.println("Finish");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}