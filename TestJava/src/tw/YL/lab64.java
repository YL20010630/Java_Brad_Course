package tw.YL;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.InetAddress;
import java.net.Socket;

public class lab64 {
	
	/*
	 	用戶端程式，負責傳送圖片到伺服器
	 */
	

	public static void main(String[] args) {
		File source = new File("dir1/圖片2.jpg");
//		建立File物件，指定要傳送的檔案
		
		byte[] buf = new byte[(int)source.length()];
//		建立一個byte陣列，大小等於檔案大小，準備儲存檔案內容
		
		try {
			BufferedInputStream bin = 
				new BufferedInputStream(new FileInputStream(source));
			bin.read(buf);
			bin.close();
//		使用BufferedInputStream讀取檔案內容到buf陣列中，並關閉輸入串流
			
			
			Socket socket = new Socket(InetAddress.getByName("10.0.101.254"), 7777);
//			連線到IP位置為""的主機，port為7777
			
			BufferedOutputStream bout = 
				new BufferedOutputStream(socket.getOutputStream());
			bout.write(buf);
			bout.flush();
			bout.close();
//			建立輸出串流，把buf中的資料傳送給伺服器，傳送關閉串流
			
			System.out.println("Send OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}