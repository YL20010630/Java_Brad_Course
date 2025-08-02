package tw.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;

public class test_13_client_byte {
	
	/*
	
		1️ 建立 Socket 物件，指定 伺服器 IP 與 port
		2️ 取得 socket 的 輸入串流 / 輸出串流
		3️ 包裝 BufferedReader / PrintWriter → 傳文字
			或者 BufferedInputStream / BufferedOutputStream → 傳檔案
		4️ 傳送你的資料
		5️ 關閉 socket
	
	*/

	/*
		宣告檔案，byte化檔案長度
		先用FileInputStream(讀入檔案)，把png檔讀進buf
		再用socket.getOutputStream(寫進伺服器)，把buf寫進伺服器
		
		
	 */
	
	public static void main(String[] args) {
		try {
			File f1 = new File("dir3/ball.png");
			
			Socket socket = new Socket("192.168.1.1",9999);

//			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(socket.getInputStream()));
//			錯誤，socket.getInputStream() 表示從伺服器接收的資料
//			但現在應該是想把圖片傳給伺服器
			
//			把圖檔讀入伺服器：先讀檔再寫入伺服器
//			f1.getInputStream
//			new BufferedInputStream(f1.getInputStream);
//			BufferedInputStream bin = new BufferedInputStream(f1.getInputStream);
//			再經由 socket.getOutputStream() 傳給伺服器
//			File物件沒有getInputStream() 方法，只能搭配FileInputStream
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(f1));		// 讀檔
			
			
//			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(f1));
//			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(socket.getOutputStream()));
//			錯誤，socket.getOutputStream()表示傳送給伺服器，FileOutputStream表示檔案寫入
//			FileOutputStream 只能對檔案，不可能對 socket 的 OutputStream
			BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());
			
//			只送一次，若圖片較大，用下面方法分送
//			byte[] buf = new byte[(int)f1.length()];
////			讀取資料
//			bin.read(buf);
//			bin.close();
////			傳送資料
//			bout.write(buf);
			
			byte[] buf = new byte[4096];
			int len;
			while ((len = bin.read(buf)) != -1) {
				bout.write(buf, 0, len);
			}
			
			bout.flush();
			bout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
