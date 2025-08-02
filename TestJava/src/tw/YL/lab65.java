package tw.YL;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class lab65 {
	
	/*
 		伺服器端程式，負責接收圖片並儲存到upload資料夾中
	 */

	public static void main(String[] args) {
		while(true) {		// 持續等待用戶端連線
			try {
				ServerSocket server = new ServerSocket(7777);
//				建立伺服器socket，監聽port7777
				
					Socket socket =  server.accept(); 
//					等待用戶端連線，連線建立後回傳socket
					
					BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
					byte[] allData =  bin.readAllBytes();
					bin.close();
//					從socket取得輸入串流，讀取所有資料，存入allData，然後關閉串流
					
					String urip = socket.getInetAddress().getHostAddress();
//					取得用戶端IP位置
					
					BufferedOutputStream bout = new BufferedOutputStream(
						new FileOutputStream(String.format("upload/%s.jpg", urip)));
//					建立輸出串流，把接收到的圖片儲存到upload資料夾中，檔名為「IP.jpg」
					
					bout.write(allData);
					bout.flush();
					bout.close();
//					將圖片寫入黨案，並關閉串流
					
					socket.close();
				
				server.close();
				System.out.println("Receive OK");
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
		
	}

}