package tw.YL;

public class lab99 {

	public static void main(String[] args) {
		

		
		
		
		
		final int ROWS = 2;   // 1
		final int COLS = 4;   // 9
		final int START = 2;   // 1
		
		for (int k = 0; k < ROWS; k++) {
			for (int y = 1; y <= 9; y++) {
				for (int x = START; x <= START+COLS; x++) {   // 一層是2~6
					int newx = x + k*COLS;
// 					當 `k=0`，`newx = 2 ~ 6`； 當 `k=1`，`newx = 6 ~ 10`
					int z = newx*y;
					System.out.printf("%d*%d=%d\t", newx, y, z);
				}
//				System.out.printf("\n");
				System.out.println();
			}
				System.out.printf("----");
				System.out.println();
		}
	
		
		
		
		
		
		
		
		
//		System.out.println("九九乘法表");
////		k為行
//		for (int k = 0; k < 2; k++) {
//			for (int y = 2; y <= 9; y++) {
//				for (int x = 2; x <= 9; x++) {
//					int newx = x + k*4;
//					int z = newx*y;
//					System.out.printf("%d*%d=%d\t" , newx, y, z);
//				}
////				System.out.printf("\n");
//			}
//				System.out.printf("----");
//				System.out.println();
//		}
		
		
		
//				for (int y = 2; y <= 9; y++) {
//					for (int x = 2; x <= 10; x++) {
//						int z = x*y;
//						System.out.printf("%d*%d=%d\t" , x, y, z);
//					}
//					System.out.printf("\n");
//				}
				
				
				
				for (int row = 0; row < 2; row++) {
					for (int y = 2; y <= 9; y++) {
						for (int x = 2; x <= 10; x++) {
							int z = x*y;
							System.out.printf("%d*%d=%d\t" , x, y, z);
						}
						System.out.printf("\n");
					}
				}
		
		
		
		
		
	}

}
