package tw.Test;

/*
 	interface筆記
	介面不能()只能{}
	不能實作如print，只能定義如void XX();，要記得寫回傳型別如void、int
	，除非寫default或static，否則就只能是抽象宣告
	
 */

public class test_05_interface {

	public static void main(String[] args) {
		Drivable obj1 = new Car();
		obj1.drive();
	}
}

//	定義一個介面
	interface Drivable{
		void drive();
	}
		
//	類別Car實作這個介面Drivable
//	static class Drivable {		// 錯誤
//	介面不能被實體化，介面只能 implements，不能 new
//	外層類別 Car 不需要 static，static 只在「巢狀類別」裡才用
//	只有巢狀類別才需要 static，外層類別不能用 static
//	Car類別在public class test_05_interface {}外面
	
//	static class Car implements Drivable {		// 錯誤
	class Car implements Drivable {
//	一個類別只有一個建構式
		public void drive() {
//		Drivable.drive(){		// 錯誤
			System.out.println("The car is driving.");
		}
	}
	
//	main → static（JVM要直接執行）
//	巢狀類別 → static（不依賴外部物件就能 new）
//	外層類別 → 不 static

	
	
	/*
	練習題 5：介面
	
	請定義：

	一個介面 Drivable，包含 void drive()

	類別 Car 實作這個介面，在 drive() 中印出「The car is driving」

	在 main 中：

	建立 Car 物件並執行 drive()
*/
	
	
