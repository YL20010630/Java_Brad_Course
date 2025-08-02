package tw.Test;

public class static01 {

	public static void main(String[] args) {
//		sayHi();		// 錯誤，sayHi() 是屬於 Tool 的
		Tool.sayHi();
		
//		Hello hello = new sayHello();
//		錯誤，sayHello() 只是 Tool 的一個方法，不能用 new 建它，要 new Tool()，然後呼叫 sayHello(
		Tool hello = new Tool();
		
//		sayHello();
		hello.sayHello();		// 錯誤，sayHello()是 非static 方法，須先有一個物件才能執行它

	}
	
	
//	public class Tool() {		// 錯誤，類別不需()
	public static class Tool{
//	因上面寫了Tool 參數 = new.....，所以這邊要static
		
		static void sayHi() {
			System.out.println("Hi!");
		}
		void sayHello() {
			System.out.println("Hello!");
		}
	}

}





/*
	請你做一個程式：
	
	1️⃣ 先有一個 Tool 類別
	
	static void sayHi() → 印出 Hi!
	
	void sayHello() → 印出 Hello!
	
	2️⃣ 在 main 裡：
	
	直接呼叫 sayHi()
	
	先建立物件再呼叫 sayHello()
*/