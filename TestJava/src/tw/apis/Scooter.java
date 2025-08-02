package tw.apis;

public class Scooter extends Bike{
	private int gear;	// 變速檔位，0 是空檔
	private String color;	// 顏色（初始會在建構子設定為紅色）

	
//	建構子（Constructor），是 Java 裡專門用來建立物件時執行的特殊方法
//	這段程式碼是 Scooter 類別的建構子
	public Scooter() {
		System.out.println("Scooter()");
		color = "red";
	}
	
	public String getColor() {
		return color;
	}

	
//	覆寫（Override）：這個 upSpeed() 是重新定義來取代 Bike 的版本
	public Scooter upSpeed() {
		if (gear > 0) {
			speed = speed < 1 ? 1 : speed * 1.8 * gear;
		}
		return this;
	}
	
	public int changeGear(int gear) {
		if (gear >= 0 && gear <=4 ) {
			this.gear = gear;
		}
		
		return this.gear;
	}
	
//	gear 就是「你想換成幾檔」
//	this.gear 是「自行車現在的檔位」
	
	
}
	
	
//	大
//	public 全類別
//	protected  子類別+同package
//	private 本類別
//	小
	
	
	
	
	
	
	
	
	