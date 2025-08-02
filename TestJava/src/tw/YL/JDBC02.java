package tw.YL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBC02 {
	
	/*
		連線MySQL
	 */

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab?user=root&password=root");
			
//			若使用SQL Server
//			String connectionUrl
//			Connection conn = DriverManager.getConnection(connectionUrl);

			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();

//		try {
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab", "root", "root");
//			System.out.println("OK2");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/lab", prop);
			System.out.println("OK3");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
