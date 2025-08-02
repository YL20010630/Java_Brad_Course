package tw.YL;

public class lab22 {

	public static void main(String[] args) {
		String s1 = "lab";
		System.out.println("lab".charAt(0));
		
		String s2 = new String();
		byte [] b = {97, 98, 99, 100, 101, 102};
		String s3 = new String(b);
		String s4 = new String(b, 2, 4);
		System.out.println(s2);		// 空白
		System.out.println(s3);		// abcdef
//		ASCII 編碼，97 = 'a'；98 = 'b'；......
		System.out.println(s4);		// cdef
//		b：來源陣列；2：開始索引（含），即從 b[2] 開始；4：長度，取 4 個字元
//		b[2] = 99 ('c')，取 4 個字元分別是 c d e f
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
}