 package tw.Test;

 /*
	abstract筆記
	抽象「方法」不能有大括號{}
	
*/
 
public class test_07_abstract {
	
	public static void main(String[] args) {
		Circle c = new Circle("red", 5);		// 字串red要記得""
		Rectangle r = new Rectangle("blue", 4, 6);
//		Shape.describe();		// 錯誤，Shape是抽象類別不能直接new，describe() 是物件的方法
//		Circle.describe();		// 錯誤，用物件呼叫
		c.describe();		// 只是呼叫，所以後面不能接{}
		System.out.println("圓形面積："+ c.getArea());
//		getArea是方法，要加小括號()
		r.describe();
		System.out.println("長方形面積："+ r.getArea());
	}


	static abstract class Shape {
//		String color() {
//			this color = color;
//		}
//		錯誤 color是變數不是方法
//		String color();		// 這式宣告函式，不是宣告變數
		String color;
		
//		寫一個建構式接收color
		public Shape (String color) {
			this.color = color;
		}
		
		abstract double getArea();
//		void describe(String color){		// 錯誤，不用帶參數
		void describe(){
			System.out.println("This is a "+ color +" shape.");
		}
	}
	
//	*若有屬性要用建構式把屬性記錄起來，this.XXX = XXX;
	static class Circle extends Shape {
		int radius;
		
//		建構式要帶宣告的參數並this
//		public void Circle(int radius) {
//		大錯誤，這是方法不是建構式
//		*建構式不能有回傳型態
		public Circle(String color,int radius) {
//		父類別需要參數，子類別一定要幫忙傳回去
			super(color);
			this.radius = radius;
		}
		
		@Override
//		double getArea(String color, int radius) {
//		錯誤，前面建構式帶參數就好，這裡不用帶參數
		double getArea() {
//			System.out.println("圓形面積："+ radius*radius*Math.PI);
//		這邊只先回傳計算值，不印
			return radius*radius*Math.PI;
		}
	
	}
	static class Rectangle extends Shape {
		int width;
		int height;
		
		public Rectangle(String color, int width, int height) {
			super(color);
			this.width = width; this.height = height;
		}
		
		@Override
//		double getArea(String color, int width, int height) {
		double getArea() {
//			System.out.println("長方形面積："+ width*height);
			return width*height;
		}
	
	}
}

// 若是Shape、Circle、Rectangle在初始class裡面public class test_07_abstract {
//	，就要加static

/*

	練習題 7：抽象類別與多型
	請完成下列需求：
	
	1️. 建立一個抽象類別 Shape，包含
	
	String color
	
	一個抽象方法 double getArea()
	
	一個普通方法 describe()，印出「This is a XXX shape.」
	
	2️. 定義兩個 Shape 的子類別：
	
	Circle，多一個 radius 屬性，並實作 getArea()（圓面積公式）
	
	Rectangle，多一個 width 和 height 屬性，並實作 getArea()（長方形面積公式）
	
	3️⃣ 在 main 中
	
	建立一個 Circle 物件，顏色為「red」，半徑 5
	
	建立一個 Rectangle 物件，顏色為「blue」，寬 4 高 6
	
	呼叫 describe() 並印出面積

*/