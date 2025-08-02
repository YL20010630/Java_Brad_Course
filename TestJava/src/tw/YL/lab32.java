package tw.YL;

public class lab32 {

	public static void main(String[] args) {
		Order order1 = new Order1("D001", 100);
//		Order是抽象類別，不能new Order()，只能被繼承(寫前面)
		Order order2 = new Order2("P001", 123);
		order1.paid();
		order1.notifyCust();
		order1.process();
		System.out.println("--------");
		order2.paid();
		order2.notifyCust();
		order2.process();
		
	}
}

//	代表「可以出貨」的功能
interface Shipable {
	void ship();
}

abstract class Order {
//	抽象類別，代表「訂單」的基本結構
	private String orderId;
	private int amount;
	Order(String orderId, int amount){
		this.orderId = orderId; this.amount = amount;
//		this.orderId：表示「這個物件的屬性 orderId」
//		orderId：表示「建構式裡傳進來的參數」
		
	}
	void paid() {System.out.println("付錢了");}
	void notifyCust() {System.out.println("通知客戶");}
	abstract void process();
//	process()會有不同出貨方式，因不固定所以寫成抽象類別
	
}
class Order1 extends Order {
	Order1(String orderId, int amount){
		super(orderId,amount);
	}
	void process() {System.out.println("數位商品出貨了");}
}
class Order2 extends Order implements Shipable{
//	 同時繼承類別 + 實作介面
	Order2(String orderId, int amount){
		super(orderId,amount);
	}
	
	void process() {
//	process()寫出具體內容了，就不再是抽象，因此不寫abstract
//	也可以寫成public/protected void process() {
//	但不能寫成private，因為權限比父類小，不合法
//	權限比較：	public > protected > void（default） > private
		System.out.println("實體商品準備出貨了");
		ship();
	}
	
	public void ship() {
		System.out.println("實體商品已經出貨");
	}
}