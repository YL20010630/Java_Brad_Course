package tw.Test;

public class test_06_private {
	
	/*
	 	練習題 6：類別修飾詞（可見性）
		請練習：
	
		建立 Person 類別，裡面有
	
		public String name
	
		private int age
	
		protected String address
	
		String phone（default 修飾詞）
	
		在 main 中
	
		建一個 Person 物件並嘗試印出 name（應該可印）
	
		嘗試印出 age（會失敗）
	
		嘗試印出 address（如果在同 package 應該可以）
	
		嘗試印出 phone（同 package 可以）
	
		觀察誰能存取、誰不能存取，並寫下原因。
	 */

	public static void main(String[] args) {
		Person obj1 = new Person();
//		錯誤
//		System.out.println(name);
//		System.out.println(age);
//		System.out.println(address);
//		System.out.println(phone);

//		public 可以直接存取
        obj1.name = "Anny";
        System.out.println("name: " + obj1.name);
		
//        System.out.println(obj1.age);		// 錯誤，private不能直接存取
        
//        protected 同 package 可存取
        obj1.address = "Taipei";
//      System.out.println("address: " + obj1.address);
        
     // default (package-private) 同 package 可存取
        obj1.phone = "123456789";
        System.out.println("phone: " + obj1.phone);
        
//      錯誤
//		System.out.println(Person.name);
//		System.out.println(Person.age);
//		System.out.println(obj1.address);
//		System.out.println(obj1.phone);

	}
	
	
//	因在初始類別裡，所以要加static
	static class Person {
//		變數宣告，不是{}是;
		public String name ;
		private int age ;
		protected String address ;
		String phone ;
		
		// 提供 public getter 取得 private 變數 age
        public int getAge() {
            return age;
            }

	}
}
	
