package tw.YL;

public class lab10 {

	public static void main(String[] args) {
		int a = 10;
		int[] ary;
//		宣告一個陣列，創一個陣列
		ary = new int[3];   
// 		完成初始化，變成 ary = [0, 0, 0]  ，裡面裝int
//		ary是物件，要產生新的記憶體new出來
		System.out.println(ary[2]);   // 0
//		System.out.println(ary[4]);   // 錯誤，超出陣列範圍
//		若ary為double，得出0.0；float-0.0；boolean-false
		System.out.println(ary.length);
		
		ary[0] = 12;
		ary[2] = 33;
		for(int i = 0; i<ary.length; i++) {
			System.out.println(ary[i]);    // 12 0 33
	}
		
		System.out.println("-----"); 
		
		for(int v : ary) {
			System.out.println(v);    // 12 0 33
		}
//		跑陣列的每個元素，等於foreach

		System.out.println("-----"); 
		System.out.println(a); 
		System.out.println(ary);    // [I@5305068a
//		印出ary的記憶體位置，[I@記憶體位址
		
		
		
		
	}
}
