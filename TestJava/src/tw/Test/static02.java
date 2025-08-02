package tw.Test;

public class static02 {

	public static void main(String[] args) {
		Tool.sayHi();
		
		Tool obj1 = new Tool();
		
//		sayHello("Anny");		// 錯誤，要透過obj1呼叫
		obj1.sayHello("Anny");
		
		Tool.add(10, 20);

	}

	static class Tool{
		static void sayHi() {
			System.out.println("Hi! XXX");
		}
//		void sayHello() {		// 要寫參數
		void sayHello(String name) {
//			System.out.println("Hello! XXX");
			System.out.println("Hello, "+name+"!");
		}
//		static int add(int a, int b);		// 錯誤，不是;   是{}
		static int add(int a, int b) {
			return a + b;
		}
	}
	
}

/*
	請你完成以下 Tool 類別，並在 main 執行這些要求：
	
	1️. Tool 必須是一個 static class，包含：
	
	static void sayHi() → 輸出 Hi, everyone!
	
	void sayHello(String name) → 輸出 Hello, XXX!
	
	2️. 在 main 中：
	
	直接用 Tool.sayHi() 呼叫
	
	再用物件呼叫 sayHello("Anny")
	

	在 Tool 中多一個：

	static int add(int a, int b)
	
	可以回傳相加結果。
	
	並在 main 中用 Tool.add(10, 20) 印出相加結果。
*/