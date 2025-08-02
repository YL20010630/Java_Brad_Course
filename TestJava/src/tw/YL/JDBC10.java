package tw.YL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.apis.BCrypt;

public class JDBC10 {
	
	/*
		會員註冊功能
	 */
	
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
//	查詢這個帳號是否已經存在，回傳一個欄位叫 count
	private static final String checkAccountSQL = "SELECT count(*) count FROM member WHERE account = ?";
	private static final int CHECK_ACCOUNT = 1;
	private static final String CHECK_ACCOUNT_FIELD = "count";
	
	private static final String registerSQL = "INSERT INTO member (account,passwd,name) VALUES (?,?,?)";
	private static final int REG_ACCOUNT = 1;		// 欄位位置?的索引
	private static final int REG_PASSWD = 2;
	private static final int REG_NAME = 3;
	
	private static Connection conn;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Account: ");
		String account = scanner.next();
		System.out.print("Password: ");
		String passwd = scanner.next();
		System.out.print("Name: ");
		String name = scanner.next();
		System.out.println("---");
		
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try{
			conn = DriverManager.getConnection(URL, prop);
			if (!isAccountExist(account)) {
				int n = registerAccount(account, passwd, name);
				if (n > 0) {
					System.out.println("Register Success");
				}else {
					System.out.println("Register Failure");
				}
			}else {
				System.out.println("Account is EXIST!");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	static boolean isAccountExist(String account) throws Exception {
		PreparedStatement pstmt = conn.prepareStatement(checkAccountSQL);
		
//		.setString()， JDBC 的方法，用來把變數的值填進SQL裡的問號?位置
		pstmt.setString(CHECK_ACCOUNT, account);
//		.setString()(要填上的位置序, 輸入的值)
		
		ResultSet rs = pstmt.executeQuery();
		
//		游標往下一筆資料（或第一筆）移動。沒有資料就回傳 false
		rs.next();
		
//		rs.getInt("count") 就是拿到剛才 SQL 查詢中 count 的值（也就是有幾筆帳號符合）
		return rs.getInt(CHECK_ACCOUNT_FIELD) > 0;
	}
	
	static int registerAccount(String account, String passwd, String name) throws Exception{
		PreparedStatement pstmt = conn.prepareStatement(registerSQL);
		pstmt.setString(REG_ACCOUNT, account);
		pstmt.setString(REG_PASSWD, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(REG_NAME, name);
		
		return pstmt.executeUpdate();
	}
	

}