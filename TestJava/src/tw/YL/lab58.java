package tw.YL;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class lab58 {
	
	/*
	 	查詢 www.ispan.com.tw 的 IP 位址，然後印在主控台
	 */

	public static void main(String[] args) {
		try {
//			InetAddress ip = InetAddress.getByName("www.ispan.com.tw");
//			查詢這個網址的IP位置，並回傳一個 InetAddress 物件
			
//			InetAddress ip = InetAddress.getByName("192.168.3.4");
			
			InetAddress[] ips = InetAddress.getAllByName("www.hinet.net");
			for(InetAddress ip : ips) {
				System.out.println(ip.getHostAddress());
//				印出所有可能的 IP
			}
			
			
//			System.out.println(ip.getHostAddress());
//			會從 InetAddress 中取出真正的 IPv4 或 IPv6 位址，印出來
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	
	
}
