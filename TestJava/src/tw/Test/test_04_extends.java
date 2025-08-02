package tw.Test;

import java.util.jar.Attributes.Name;

public class test_04_extends {
	
	/*
	 	練習題 4：繼承
	 	
		請定義：
	
		父類別 Animal，包含 String name 與 void speak()，印出「XXX makes a sound」
	
		子類別 Dog，覆寫 speak()，印出「XXX barks」
	
		在 main 中：
	
		建立一隻 Dog，叫做「Lucky」，並呼叫 speak()
	 */


	public static void main(String[] args) {
//		Animal Lucky = new Dog();		// 錯誤
		Dog Lucky = new Dog("Lucky");
		Lucky.speak();
		System.out.println(Lucky.name);

	}
	
//	注意，因為 main 是 static，所以它只能直接使用 static 類別
	static class Animal{
		String name;
		
//		沒寫建構式，補上了
//		一個類別只有一個建構式
		public Animal(String name) {
			this.name = name;
		}
		
		void speak() {
//			System.out.println("XXX makes a sound");
			System.out.println(name+" makes a sound");
		}
	}
	
	static class Dog extends Animal {
//		沒寫建構式，補上了
		public Dog(String name) {
			super(name);
		}
		
		@Override
		void speak(){
			System.out.println(name + " barks");
		}
	}
	

}
