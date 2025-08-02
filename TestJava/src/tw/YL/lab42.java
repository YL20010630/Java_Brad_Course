package tw.YL;

import java.util.function.IntToDoubleFunction;

/*
 	Java 的執行期錯誤
 */

public class lab42 {

	public static void main(String[] args) {
		int a = 10, b = 3;
		int c;
		int [] d = {1, 2, 3, 4};
		
		System.out.println("Hello, World");
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[20]);
			
//		e 是變數名稱，代表這次被丟出來的錯誤物件
			
		}catch (ArithmeticException e) {
//		ArithmeticException 是處理發生算術錯誤
			 System.out.println("Oooop!");
			 
		}catch (ArrayIndexOutOfBoundsException e) {
//		ArrayIndexOutOfBoundsException 意思是 你存取陣列超過它的範圍
				 System.out.println("Oooop!(2)");
				 
		}catch (RuntimeException e) {
//		RuntimeException 是 Java 所有「執行期例外」的爸爸，只要是執行期例外，都會被它抓住
			 System.out.println("XXX");
	}
		

		System.out.println("Finish");
	}
}
