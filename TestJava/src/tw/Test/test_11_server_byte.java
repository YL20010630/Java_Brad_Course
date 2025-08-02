package tw.Test;

import java.io.BufferedInputStream;		// 還是位元組，只能用read()一個個讀位元
import java.io.BufferedOutputStream;
import java.io.BufferedReader;			// 可讀整行文字的緩衝區 ，可用readLine()
import java.io.FileOutputStream;
import java.io.InputStream;				// 取得位元組串流
import java.io.InputStreamReader;		// 位元組串流 轉 字元串流
import java.io.OutputStream;			// 取得輸出串流
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class test_11_server_byte {
	
	/*
	 	1️ 建立 ServerSocket
	 	2️ 等待 accept()
	 	3️ 取得 socket 的輸入/輸出串流
	 	4️ 處理收送邏輯
	 	5️ 視需要回應
	 	6️ 關閉連線
	 	
	 */
	

	public static void main(String[] args) {
		
//		傳檔案、圖片或其他位元組
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();
			
			
//			一次讀一部分
//			接收位元組流
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
//			還是位元組流，BufferedInputStream提供read()，但不支援 readLine()，只能一個一個位元讀
			
//			準備寫檔
			FileOutputStream fout = new FileOutputStream("dir2/test_10_server_byte-upload.jpg");
			
			byte[] buf = new byte[4096];
			int len;
			while((len = bin.read(buf)) != -1) {
//				fout.write(len);		// 錯誤，len是讀到的位元組數
				fout.write(buf, 0 ,len);
			}
			fout.close();
			
			
//			一次讀全部寫全部，所以比上面的多建了緩衝區Buffered
//			String urip = socket.getInetAddress().getHostAddress();
//			
//			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
//			byte[] allData = bin.readAllBytes();
//			bin.close();
////			從socket取得輸入串流，讀取所有資料，存入allData，然後關閉串流
//			
//			BufferedOutputStream bout = new BufferedOutputStream(
//					new FileOutputStream(String.format("upload_%s.jpg", urip)));
//			bout.write(allData);
//			bout.close();
//			建立一個可以把資料快取後，寫入指定檔案 的串流
			
//			String.format(...)	產生檔案名稱
//			FileOutputStream(...)	檔案位元組輸出串流
//			BufferedOutputStream(...)	包裝成緩衝輸出，寫檔更快
			
			
			socket.close();
			server.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			

	}

}
