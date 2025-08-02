package tw.apis;
import java.util.Random;

public class TWId {

	private String id;
	private static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
//	Overload 覆載
	public TWId() {
//		this((int)(Math.random()*2) == 0);
		this(new Random().nextBoolean());
//	 	無參數建構子，會隨機產生性別（true或false），並呼叫下一個建構子建立身分證字號
	}
	
	public TWId(boolean isMale) {
		this(isMale, letters.charAt(new Random().nextInt(26)));
//	 	傳入性別後，隨機從 letters 取得一個區域字母，呼叫更完整的建構子建立身分證
	}
	
	public TWId(char area) {
		this(new Random().nextBoolean(), area);
//		傳入區域字母，隨機產生性別，再呼叫更完整建構子
	}
	
	public TWId(boolean isMale , char area) {
		StringBuffer sb = new StringBuffer();
//		自己組出一組合法的身分證字號，不是傳進來檢查別人的
		sb.append(area);
		sb.append(isMale ?'1' :'2');
		for (int i=0 ; i<7 ;i++) sb.append(new Random().nextInt(10));
//		nextInt(10) 表示從 0（包含）到 10（不包含） 中，隨機挑選一個整數，也就是 0 到 9 之間的數字
//		nextInt(10) 是 Random 這個類別的方法，所以必須先有一個 Random 類別的物件，才能呼叫它的 .nextInt(10) 方法
//		只有七碼是因為最後一碼是檢查碼不是隨機產生
		for (int i=0 ; i<10 ;i++) {
			if (isRightID(sb.toString() +i)) {
//			用 isRightID 這個方法，檢查這個號碼檢查碼i有沒有「通過身分證驗證規則」
				id = sb.append(i).toString();
//				先加尾碼再轉字串，id為字串
				break;
			}
		}
	}
	
	
	private TWId(String id) {
		this.id = id;
	}
//		this.id 是「這個物件裡的 id 欄位」
//		id 是建構式參數。
//		如果你寫 new TWID("A123456789")，就會把 "A123456789" 存到這個物件的 id 裡。
	
	
	public String getId() {
		return id;
	}
	
	public boolean isMale() {
		return true;
	}
	
	public String getLocation() {
				return "台中市";
				
		}
	

	
	

	
	public static TWId createTWId(String id) {
		if (isRightID(id)) {
			return new TWId(id);
		}else {
			return null;
		}
	}
//	靜態方法，接收字串，先用 isRightID 驗證格式與檢查碼，合法則建立TWId物件，非法則回傳 null
//	這段是給外部使用者提供「給我一組字串，如果是合法身分證就幫我轉成 TWId 物件」的功能
	
	
	public static boolean isRightID(String id) {
		boolean isRight = false;
//		預設為false，若if通過則變為true

//		if(id.length()==10) {
//			char c1 = id.charAt(0);
//			if(letters.indexOf(c1) != -1) {
//				char c2 = id.charAt(1);
//				if(c2 == '1' || (c2 == '2'){
//
//				}
//			}
//		}
		
//		if (id.matches("[A-Z][12][0-9]{8}")) {
//			isRight = true;
//		}
		if (id.matches("[A-Z][12][0-9]{8}")) {
			char c1 = id.charAt(0);
			int a12 = letters.indexOf(c1) +10;
			System.out.println(a12);
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			String s1 = id.substring(1, 2);
//			substring(1, 2) 代表從 第1個索引開始（含），到 第2個索引結束（不含）
			int n1 = Integer.parseInt(s1);		// 字串"1"，轉成數字1
			int n2 = Integer.parseInt(id.substring(2, 3));
			int n3 = Integer.parseInt(id.substring(3, 4));
			int n4 = Integer.parseInt(id.substring(4, 5));
			int n5 = Integer.parseInt(id.substring(5, 6));
			int n6 = Integer.parseInt(id.substring(6, 7));
			int n7 = Integer.parseInt(id.substring(7, 8));
			int n8 = Integer.parseInt(id.substring(8, 9));
			int n9 = Integer.parseInt(id.substring(9, 10));

			int sum = a1*1 + a2*9 + n1*8 + n2*7 + n3*6 + 
					n4*5 + n5*4 + n6*3 + n7*2 + n8*1 + n9*1 ;
			isRight = sum % 10 == 0;
			
		}
		
		return isRight;
	}
	
	
	
}
