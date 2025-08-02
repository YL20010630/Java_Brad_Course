package tw.YL;

public class lab12 {

	public static void main(String[] args) {
////		使用陣列的版本
//		int[] p = new int [7];
//		
//		for(int i = 0; i < 100; i++) {
//			int point = (int)(Math.random()*6 +1);  // 1 ~ 6
//			if(point >= 1 && point <= 6) {
//				p[point]++;
////				point 是 1~6，就累加對應點數的次數。
//			} else {
//				p[0]++;
//			}
//		}
//		
//		if(p[0] == 0) {
////		代表這 100 次都產生了合法的點數（1~6）
//			for(int i = 0; i < p.length; i++) {
//				System.out.printf("%d點出現%d次\n", i, p[i]);
//			}
//		} else {
//			System.out.print("Error");
//		}
		
		
		
		
		
		
//		使用遊戲的版本
		int[] p = new int [7];
		for(int i = 0; i < 100000; i++) {
			int point = (int)(Math.random()*9 +1);
			if(point >= 1 && point <= 9) {
				p[point<=6?point:point-3]++;
			} else {
				p[0]++;
			}
		}
		
		if(p[0] == 0) {
//		代表這 100 次都產生了合法的點數（1~6）
			for(int i = 1; i < p.length; i++) {
				System.out.printf("%d點出現%d次\n", i, p[i]);
			}
		} else {
			System.out.print("Error");
		}
		
		
		
		
		
		
		

	}

}
