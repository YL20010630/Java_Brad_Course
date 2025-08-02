package tw.Test;

public class test_01_static {

	/*
	 練習題 1：靜態方法與物件方法
	 請完成一個 Tool 類別，包含：
	 static 方法 sayHi()，印出「Hi!」
	 非 static 方法 sayHello(String name)，印出「Hello, XXX」
	 static 方法 add(int a, int b)，回傳相加結果
	 在 main 中：
	 直接呼叫 sayHi
	 建立一個 Tool 物件並呼叫 sayHello
	 使用 add 計算 7+3 並印出
	
	*/
	
	/*
		static筆記
		static只能用在類別上
	 */
	
	/*
		public筆記
		父類如果是 public → 子類也必須 public
		只看父類別，所以在某一方法public，其內裡可以不用public
		若在父類別裡的方法寫了public，其父類別裡的宣告不用public，但其子類別要對同名覆寫方法public
		
		
	 */
	
	public static void main(String[] args) {
		Tool.sayHi();
		Tool obj1 = new Tool();
		
//		obj1.sayHello();		// 錯誤，sayHello需要回傳參數
		obj1.sayHello("Anny");
		
//		Tool.add(7, 3);		// 錯誤，沒印出結果
//		Tool.add(7, 3){System.out.println(a + b);}		// 錯誤
		System.out.println(Tool.add(7, 3));
		
	}
		
	}
	
//	public class Tool {		// 一個檔案只能有 一個 public 類別
	class Tool {

//		static sayHi() {		// 錯誤，要寫回傳值型態，因為不回傳直接印，所以回傳執型態是void
		static void sayHi() {
			System.out.println("Hi!");
		}
		void sayHello(String name) {
			System.out.println("Hello, "+name+ "!");
		}
//		static add(int a, int b) {		// 錯誤，要寫回傳值型態
			static int add(int a, int b) {
			return a + b;
		}
	}
	
	/*
	
		練習題 1：靜態方法與物件方法
		請完成一個 Tool 類別，包含：
	
		static 方法 sayHi()，印出「Hi!」
	
		非 static 方法 sayHello(String name)，印出「Hello, XXX」
	
		static 方法 add(int a, int b)，回傳相加結果
	
		在 main 中：
	
		直接呼叫 sayHi
	
		建立一個 Tool 物件並呼叫 sayHello
	
		使用 add 計算 7+3 並印出
	
		練習題 2：陣列與 for-each
		請寫一個程式：
	
		建立 int[] nums = {3, 7, 2, 5, 8}
	
		用 for-each 印出每個元素
	
		計算總和並印出
	
		練習題 3：HashSet
		請寫一個程式：
	
		建立 HashSet<String> names
	
		加入三個不同名字
	
		嘗試再加入一個重複的名字
	
		最後印出 names 的內容
	
		並用 for-each 走訪印出每一個
	
		練習題 4：繼承
		請定義：
	
		父類別 Animal，包含 String name 與 void speak()，印出「XXX makes a sound」
	
		子類別 Dog，覆寫 speak()，印出「XXX barks」
	
		在 main 中：
	
		建立一隻 Dog，叫做「Lucky」，並呼叫 speak()
	
		練習題 5：介面
		請定義：
	
		一個介面 Drivable，包含 void drive()
	
		類別 Car 實作這個介面，在 drive() 中印出「The car is driving」
	
		在 main 中：
	
		建立 Car 物件並執行 drive()
	
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
	