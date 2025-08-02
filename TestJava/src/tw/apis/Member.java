package tw.apis;

import java.util.Objects;

//	DTO / Entity（資料物件）

public class Member {
	private int id;
	private String name;
	private String passwd;	// plain or hash => plain
	private String account;
	
//	無傳參數建構式
	public Member() {}
//	先 new 出一個空物件（用無參數建構式），Member member = new Member();
// 	再用.setName()、setAccount()慢慢把資料填上去
	
	
	public Member(int id, String name, String passwd, String account){
		this.id = id; this.name = name;
		this.passwd = passwd; this.account = account;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAccount() {
		return account;
	}
	
	
//	這裡是先比hashcode再比equal
//	equals() 用來比對兩個物件是否相等，用 id 比較
//	hashCode() 用整數雜湊值來表示該物件，同樣依賴 id
//	toString() 讓物件變成易讀字串，清晰顯示 id 與 name
	
//	下面這塊equals區塊只要 id 一樣，就視為相同的 Member，即使 name 不同也無所謂。
//	this是拿來被比較的自己m1，obj是跟m1比較的m2
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
//		如果兩個參考變數指到同一個物件，就直接相等
		
		if (obj == null || getClass() != obj.getClass()) return false;
//		如果傳入 null 或型別不同，當然不相等
//		getClass() 會回傳這個物件的類別
		
		Member other = (Member)obj;
//		要比較id，但obj是Object 型別沒有id，想使用 Member 的屬性，必須轉型成 Member才能寫other.id
		
		return this.id == other.id;
//		只要id相同，就判斷為「相等的會員」
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
//		Objects.hash(id) 會把 id 轉成一個雜湊碼。
//		保證相同 id 產生相同 hashCode
	}
	
	@Override
	public String toString() {
		return String.format("%d:%s", id, name);
//		用toString轉成字串才不會印出記憶體位置
	}
	
}

/*
 	假設先加一個 Member(1, "Andy") 進去，
 	HashSet 先呼叫 hashCode 得到一個號碼，放進雜湊桶，
 	再加 Member(1, "David") 進去，
 	也先呼叫 hashCode → 產生同樣號碼，
 	再執行 equals 比對 → id 一樣 → 相同 → 不會放進去，HashSet就跳過
 	
 */






