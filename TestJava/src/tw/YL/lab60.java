package tw.YL;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class lab60 {
	
	/*	
	 	UDP，快速、無連線、不可靠、不安全
	 	接收端
	 	
		伺服器端程式，持續監聽UDP封包，接收並印出訊息
	 */

	public static void main(String[] args) {
		byte[] buf = new byte[4*1024];
//		建立一個 4K 的緩衝區，用來接收資料
		
//		一直收封包直到收到 quit
		while(true) {
			try {
				DatagramSocket socket = new DatagramSocket(8888);
//				建立一個 UDP socket，並且 監聽 8888 埠
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
//				建立一個「收件包裹」用來放進來的資料
				
				System.out.println("wait...");
				socket.receive(packet);
//				
				
				socket.close();
				System.out.println("Receiver OK");
				
				String urip =  packet.getAddress().getHostAddress();
//				packet.getAddress()會回傳傳送方（client）的 InetAddress 物件，例如：/192.168.1.5
//				getHostAddress()會把上面 InetAddress 的IP 位址（字串）取出來，例如 192.168.1.5
				
				int len = packet.getLength();
				byte[] data = packet.getData();
				String msg = new String(data,0,len);		// 你收到名為data資料的byte陣列中從0開始到len的msg
//				urip：傳送者，IPlen：實際收到的長度，data：封包內的位元組，msg：轉成字串

				
//				System.out.printf("%s : %s\n", urip, new String(data, 0 , len));
				System.out.printf("%s : %s\n", urip, msg);
				if (msg.equals("quit")) {
					break;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				break;
			}
		}
	}

}