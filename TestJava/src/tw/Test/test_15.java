package tw.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class test_15 {
	private static final String URL = "jdbc:mysql://localhost/lab";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String querySQL = "SELECT * FROM member WHERE id = ?";
	private static final String insertSQL = "INSERT INTO member(account, passwd, name) VALUE(?,?,?)";
	private static final String updateSQL = "UPDATE FROM member SET account = ? WHERE id = ? ";
	private static final String likeSQL = "SELECT * FROM member WHERE name LIKE ? OR account LIKE ?";
	private static final String delSQL = "DELETE FROM member WHERE id = ?";
	
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", USER);
		prop.setProperty("password", PASSWORD);
		
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
//			PreparedStatement pstmt = conn.prepareStatement(querySQL);
//			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
//			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
//			PreparedStatement pstmt = conn.prepareStatement(likeSQL);
			PreparedStatement pstmt = conn.prepareStatement(delSQL);
			
			
			Scanner scanner = new Scanner(System.in);
			
//			查詢特定ID
//			System.out.print("請輸入要查詢的ID：");
//			int id = scanner.nextInt();
//			pstmt.setInt(1,id);		// 傳入參數
			
//			修改
//			System.out.print("請輸入使用者的ID：");
//			int id = scanner.nextInt();
//			System.out.print("請輸入新的帳號：");
//			String account = scanner.next();
//			pstmt.setString(1, account);
//			pstmt.setInt(2,id);

			
//			新增
//			System.out.print("請輸入要新增的帳號：");
//			String account = scanner.next();
//			System.out.print("請輸入密碼：");
//			String password = scanner.next();
//			System.out.print("請輸入名字：");
//			String name = scanner.next();
//			pstmt.setString(1, account);
//			pstmt.setString(2, password);
//			pstmt.setString(3, name);
			
//			關鍵字查詢
//			System.out.print("請輸入關鍵字：");
//			String key = scanner.next();
//			String search = "%" + key + "%";
//			pstmt.setString(1, search);
//			pstmt.setString(2, search);
			
//			刪除
//			System.out.print("請輸入要刪除的ID：");
//			int id = scanner.nextInt();
//			pstmt.setInt(1, id);
			
			
			
			
//			執行搜尋
//			ResultSet rs = pstmt.executeQuery();		// 再執行查詢
			
//			執行更新並回傳影響筆數
			int n = pstmt.executeUpdate();
			if (n>0) {
				System.out.println("執行成功，共影響" + n + "筆資料");
			}else {
				System.out.println("執行失敗");
			}
			
			
			
//			while是全部查詢，if是特定查詢
//			while (rs.next()) {
//				
////				cust表欄位
////				int id = rs.getInt("id");
////				String cname = rs.getString("cname");
////				String tel = rs.getString("tel");
////				Date birthday = rs.getDate("birthday");
////				System.out.printf("ID：%d \t 姓名：%s \t 電話：%s \t 生日：%s\n", id, cname, tel, birthday);
//				
////				member表欄位
//				int id = rs.getInt("id");
//				String account = rs.getString("account");
//				String password = rs.getString("passwd");
//				String name = rs.getString("name");
//				System.out.printf("ID：%d \t 帳號：%s \t 密碼：%s 姓名：%s\n",
//						id, account, password, name);
//			}
			
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		

	}

}


/*
			🧩 基礎題（查詢 / 顯示）
		1. 查詢所有客戶資料
		請撰寫一段程式，查詢資料表 cust 中所有資料，並用 printf 顯示成這樣：
		
		ID: 1, 姓名: 小明, 電話: 0912345678, 生日: 2000-01-01
		ID: 2, 姓名: 小美, 電話: 0933445566, 生日: 1995-05-20

		2. 查詢特定 ID 的客戶
		輸入一個 ID（如 3），查詢該筆 cust 資料，若無該 ID，顯示「找不到」。
		
		🛠️ 中階題（新增 / 更新 / 刪除）
		3. 新增一筆客戶資料
		請寫一段程式，可以將以下資訊新增到資料表 cust：

		姓名：江江
		電話：0988776655
		生日：2001-06-30
		
		4. 修改電話（UPDATE）
		讓使用者輸入 ID 和 新電話號碼，更新 cust 中該筆資料的 tel 欄位。
		
		5. 刪除資料
		輸入一個 ID，刪除 cust 中對應的資料。若該 ID 不存在，顯示「無此資料，刪除失敗」。
		
		🔁 DAO / 交易控制題
		6. 使用 DAO 實作以下功能：
		請建立 CustDAO 介面與 CustDAOImpl 類別，實作以下方法：

		void addCust(Cust c);
		Cust findById(int id);
		List<Cust> findAll();
		void updateTel(int id, String newTel);
		void deleteCust(int id);
		其中 Cust 是你自訂的 DTO 類別，有 id, name, tel, birthday 四個欄位。
		
		7. 實作交易控制
		假設要同時更新兩筆資料（ID 3、ID 6）的電話，如果中間任何一筆出錯（可模擬除以 0），就要整個 rollback。請實作 conn.setAutoCommit(false) 開始交易、若有錯誤則 rollback。
		
		📦 加分題（難）
		8. 輸入關鍵字模糊查詢
		讓使用者輸入一個關鍵字，例如 美，查詢所有 name 包含 美 的客戶，顯示其完整資訊。
		
		9. 將查詢結果匯出成 CSV 檔
		查詢全部資料後，寫入一個檔案 cust.csv，格式如下：

		id,name,tel,birthday
		1,小明,0912345678,2000-01-01
		...
 */