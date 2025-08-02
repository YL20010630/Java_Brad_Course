package tw.YL;

public class lab15 {

	public static void main(String[] args) {
//		int a = 10, b = 3;
//		int c = a;   // c變10
//		a = b;       // a變3
//		b = c;       // b變10
		
//		int a = 10, b = 3;
//		a = a + b;   // a = 13
//		b = a - b;   // b = 10
//		a = a - b;   // b = 3
		
		int a = -10, b = 4;
		a = a ^ b;   // a = -14
		b = a ^ b;   // b = -10
		a = a ^ b;   // a = 4
		
		System.out.printf("a = %d, b = %d\n",a, b);
		
//		二進位
		System.out.println(3 & 2);    // 2
		System.out.println(3 | 2);    // 3
		System.out.println(3 ^ 2);    // 1
		

	}

}
