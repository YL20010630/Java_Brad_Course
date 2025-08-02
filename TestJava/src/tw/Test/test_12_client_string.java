package tw.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;		// 記得加true
import java.net.InetAddress;
import java.net.Socket;

public class test_12_client_string {
	
	/*
		1️ 建立 Socket 物件，指定 伺服器 IP 與 port
		2️ 取得 socket 的 輸入串流 / 輸出串流
		3️ 包裝 BufferedReader / PrintWriter → 傳文字
			或者 BufferedInputStream / BufferedOutputStream → 傳檔案
		4️ 傳送你的資料
		5️ 關閉 socket

	 */

	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket(InetAddress.getByName("192.168.1.1"), 1111);			
			System.out.println("已連接到伺服器");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
//			PrintWriter pw = new PrintWriter(new OutputStream(socket.getOutputStream()));
			
			String msg = "客戶端msg";
//			pw.write 會寫進 buffer
//			pw.write(br);		// 錯誤
			pw.write("客戶端write");
			pw.println("客戶端println");
			pw.write("Hello, World");
			pw.write(97);
			pw.append(msg);
			
			pw.flush();
//			因為 server 端通常是用 readLine，所以建議多用 println
			
//			錯誤，用戶端不能用while去讀server傳回來的資料，因server可能不會馬上斷線，因此會一直等待
//			String line;
//			while ((line = br.readLine()) != null) {
//				pw.append(line);
//				System.out.println("Client 收到: "+ line);
//			}
			
//			錯誤，readLine();本身就會回傳字串，不需要再傳變數
//			String line;
//			br.readLine(line);
			
			String line = br.readLine();
			System.out.println("Client 收到伺服器回應: "+ line);
			
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
