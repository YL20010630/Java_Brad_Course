package tw.YL;

import tw.apis.BCrypt;

public class JDBC09 {

	public static void main(String[] args) {
		String passwd = "123456";
		
//		把密碼用 BCrypt 加密（雜湊 + 加鹽）成不可逆的格式
//		gensalt() 會自動產生隨機 salt，讓同一個密碼每次加密後結果都不一樣
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashPasswd);
		
		String passwd1 = "123457";
		if (BCrypt.checkpw(passwd1, hashPasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
		
		
	}

}