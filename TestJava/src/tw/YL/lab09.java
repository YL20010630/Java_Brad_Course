package tw.YL;

public class lab09 {

	public static void main(String[] args) {
		
//		int i = 0;
//		for (; i < 10; i++) {
////		這裡沒有初始化（因為 i 已在外面宣告）
////			System.out.println(i);     // 0 ~ 9
//			System.out.println(i++);   // 0 2 4 6 8
//		}
//		System.out.println("-----我是分隔線-----"); 
//		System.out.println(i);   // 10
		
		
		int i = 0;
		for (printTest(); i < 10; printLine()) {
//			在一開始呼叫函式printTest()
//			每跑一次呼叫一次函式printLine()
//			0 ~ 9 次，共十次，所以共呼叫十次printLine()
			
//			System.out.println(i);     // 無限0
			System.out.println(i++);   // 0 ~ 9
		}
		System.out.println("-----我是分隔線-----"); 
		System.out.println(i);   // 10
		
		
	}
	
	
	
	
//	等於 function printTest() {}
	static void printTest() {
		System.out.println("Test");   // 在最開頭寫Test
	}
	
	static void printLine() {
		System.out.println("---------");   // 在每個數字間隔----
	}
	
	
	
}
