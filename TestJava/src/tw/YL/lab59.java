package tw.YL;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class lab59 {
	
	/*
	 	UDP，快速、無連線、不可靠、不安全
	 	發送端
	 	
 		用戶端程式，負責傳送文字訊息到伺服器
	 */

	public static void main(String[] args) {
		String msg = "Hello, World, 59";
		byte[] data = msg.getBytes();
//		將字串轉為位元組陣列
		
		try {
			DatagramSocket socket = new DatagramSocket();
//			UDP 的「郵筒」，負責寄送封包
//			UDP 的 socket 不需要 connect，打開就可以傳
			
			DatagramPacket packet = new DatagramPacket(data, data.length,
					InetAddress.getByName("10.0.101.254"), 8888);
//			建立一個 DatagramPacket 封包
//			data：要傳送的內容，data.length：長度，InetAddress.getByName(...)：目的地 IP，8888 → 目的地的 UDP port
			
			socket.send(packet);
			socket.close();
			System.out.println("Send NOT OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
