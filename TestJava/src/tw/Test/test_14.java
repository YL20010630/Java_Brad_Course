package tw.Test;

import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class test_14 {

	public static void main(String[] args) {
		
//		(1) Order訂單系統練習main區塊
		
//		除了抽象類別，其他class都要new
//		new出來的類別要記得帶進自創父類別參數
		DigitalOrder obj1 = new DigitalOrder("A01", 100);
		PhysicalOrder obj2 = new PhysicalOrder("B02", 200);
		
		obj1.paid();
		obj1.notifyCustomer();
		obj1.process();
		obj2.paid();
		obj2.notifyCustomer();
		obj2.process();
		
//		(2) ID練習區塊

//		若new 物件就馬上驗證，驗證程式要放在建構式
		isValidTWId id1 = new isValidTWId("A123456789");
		id1.isValidTWId();
		
//		(3) HashSet訂單清單管理驗證練習main區塊
		HashSet<Order> orders = new HashSet<>(); 
//		Object order1 = new DigitalOrder("A01", 100);		// 錯誤，不需用Object，直接Order
//		Object order2 = new PhysicalOrder("B02", 200);
		Order order1 = new DigitalOrder("A01", 100);
		Order order2 = new PhysicalOrder("B02", 200);
		orders.add(order1);
		orders.add(order2);
		orders.add(new DigitalOrder("C02", 300));
		orders.add(new DigitalOrder("D04", 400));
		
//		for(String order : orders) {		// 錯誤，不是String是Order
		for(Order order : orders) {
			System.out.print("order："+order+"\n");		// \n要放在字串""裡		
		}
//		System.out.printf("orders：%s\n", orders);
		
//		Integer<類別> 單 = 多.iterator();
		Iterator<Order> orderIter = orders.iterator();
		while(orderIter.hasNext()) {
			System.out.println(orderIter.next());
		}
		
		
		

	}
	

//	(1) Order練習區塊

//	interface Shipable() {		// 錯誤，介面不能()只能{}
//		ship(){		// 錯誤，定義要寫回傳型別，例如void(沒有回傳值)、int
//		void ship() {		// 抽象宣告，不能{}只能;
	interface Shipable {
		void ship();
//			System.out.println("物流配送中");		// 錯誤，介面不能有實作
		}
	
	static abstract class Order {		
		public String orderId;
		public int amount;
		
		public Order(String orderId, int amount) {
			this.orderId = orderId;
			this.amount = amount;
		}
		
		void paid() {		// 類別沒有public，裡面的宣告定義方法也可以不寫
			System.out.println("訂單已付款");
		}
		public void notifyCustomer() {
			System.out.println("已通知顧客");
		}
		
//		public abstract  void process() {		// 錯誤，抽象方法不能有大括號
//			super();		// 錯誤，抽象類別才要super()
//		}
		public abstract  void process();
		
		public  String toString() {
			return "訂單編號："+orderId+", 金額："+amount;
//			或是
//			return String.format("訂單編號：%s, 金額：%d", orderId, amount);
		}
		
	}
	static class DigitalOrder extends Order {		// 類別都要寫建構式
		public DigitalOrder(String orderId, int amount) {		// 父類別有參數子類別建構式也要帶參數
			super(orderId, amount);
		}
		@Override
		public void process(){		// 要記得加public
			System.out.println("已發送下載連結");
		}
	}
	static class PhysicalOrder extends Order implements Shipable {
		public PhysicalOrder(String orderId, int amount) {
			super(orderId, amount);
		}
		public void process(){
			System.out.println("實體商品打包");
			ship();
		}
//		介面宣告沒有default或static(有才可印字)，這裡要補印出的字
		public void ship() {
			System.out.println("實體商品已經出貨");
		}
	}


//	(2) ID使用者驗證練習區塊
	
	static class isValidTWId{
		String id;
		public isValidTWId(String id) {
			this.id = id;
			
//			驗證方法寫在建構式裡
			if(id.matches("[A-Z][12][0-9]{8}")) {
				System.out.println("驗證成功："+ id);
			} else {
				System.out.println("驗證失敗");
			}
		}
		public boolean isValidTWId() {
//			驗證方法寫在方法裡
			return id != null && id.matches("[A-Z][12][0-9]{8}");
			
			
//			錯誤
//			if(id.matches("[A-Z][12][0-9]{8}")) {
//				return true;
//			} else {
//				return false;
//			}
		}
	}
	
//	(3) HashSet訂單清單管理驗證練習區塊
	
	
//	(4) GUI 猜數字練習區塊
	
//	public class GUI extends JFrame implements ActionListener{
//		JButton btn = new JButton("猜");
//		JTextField input = new JTextField("請輸入文字");
//		JTextPane log = new JTextPane();
//
//		
//		GUI(){
//			setSize(640, 480);
//			setVisible(true);
//			setDefaultCloseOperation(EXIT_ON_CLOSE);
//		}
//		
//	}
//	public class createAnswer extends GUI {
//		public createAnswer(int answer) {
//			final int nums = 10;
//			int[] poker = new int[nums];
//			for(int i=0; i<poker.length;i++) {poker[i] = i;}
//			for(int i = nums -1; i>0 ; i--) {
//				int r = (int)(Math.random()*(i+1) );
//				int temp = poker[r];
//				poker[r] = poker[i];
//				poker[i] = temp;
//			}
//		}
//	}
	
	
	
	
	
	
	
	
	
	
	
	
}
		
	
	


/*

	🌟 綜合 Java 經典練習題 🌟
		題目敘述：
		請設計一個「電商訂單管理系統」模擬程式，要求包含下列功能：
	
	(1) 訂單系統(可參考lab32)
		設計一個抽象類別 Order
		欄位：orderId (字串)、amount (金額, int)
		方法：paid()、notifyCustomer()（一般方法），process()（抽象方法）
		請設計兩個子類別
		DigitalOrder 數位訂單
		process() 印出「已發送下載連結」
		PhysicalOrder 實體訂單 
		process() 印出「實體商品打包」後呼叫 ship() 出貨
		PhysicalOrder 同時必須實作 Shipable 介面
		ship() 印出「物流配送中」
	
	(2) 使用者驗證(可參考lab25、TWID)
		使用靜態方法 isValidTWId(String id) 驗證身分證字號
		規則：字首為大寫英文字母，後面 9 碼
		輸入合法回傳 true，不合法回傳 false
		測試輸入幾組字串並印結果
	
	(3) 訂單清單管理(可參考lab34、35)
		以 HashSet<Order> 儲存所有訂單
		示範如何透過 Iterator 與 foreach 各印出所有訂單
		記得覆寫 Order 的 toString() 顯示格式為
		訂單編號: xxxx, 金額: xxx
	
	(4) GUI 猜數字
		參考你的 GuessGame 寫一個 3A0B 遊戲
		介面使用 JFrame
		JTextField 輸入
		JTextPane 顯示紀錄
		答案用 createAnswer(int d) 產生
		勝利 (3A0B) 顯示 JOptionPane 提示「WINNER」
		嘗試次數超過 10 次也顯示「LOSER」
	
	(5) 進階多型
		設計一台 Bike，有 speed 屬性與 upSpeed()、downSpeed() 方法
		設計 Scooter 繼承 Bike 並覆寫 upSpeed() 加入「檔位」邏輯
		示範 method chaining (例如 bike.upSpeed().upSpeed().downSpeed())
		覆寫 toString() 顯示目前速度
	
	🌟 加分挑戰 🌟
		把 Order 做成泛型 Order<T>，可以同時支援「顧客資訊」
		在 GUI 中加入「重新開始」按鈕
		讓 HashSet 以 TreeSet 排序金額

*/
