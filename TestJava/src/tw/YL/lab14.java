package tw.YL;

public class lab14 {

	public static void main(String[] args) {
		
//		二維陣列
		
		int[][] a;
		a = new int[3][4];
//		3列（row）→ a[0], a[1], a[2]
//		每列有 4 個欄位（column）→ a[0][0] ~ a[0][3] 等
		
//		得出結果：
//		a = [
//		     [0, 0, 0, 0],
//		     [0, 0, 0, 0],
//		     [0, 0, 0, 0]
//		   ]

		
		int[][] b;
		b = new int[3][];
//		b 有 3 列，但還沒說每列有多長
		b[0] = new int[4];
		b[1] = new int[2];
		b[2] = new int[3];
		
//		得出結果：
//		b = [
//		     [0, 0, 0, 0],
//		     [0, 0],
//		     [0, 0, 0]
//		   ]

		
		
		System.out.println(b.length);       // 3
		System.out.println(b[0].length);    // 4
		System.out.println(b[1].length);    // 2
		System.out.println(b[2].length);    // 3
		
		for (int[]v:b) {
//			System.out.print(v+" ");   // 錯誤，因為沒轉成字串，所以這是記憶體位置
			for(int vv :v) {
				System.out.print(vv+" ");
			}
				System.out.println(" ");
			}

	}

}
