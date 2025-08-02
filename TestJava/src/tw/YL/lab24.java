package tw.YL;

public class lab24 {

	public static void main(String[] args) {
		String name = "Lycia莉西亞";
		System.out.println(name);			// Lycia莉西亞
		String name2 = name.concat("Chen");
//		concat 字串串接
		System.out.println(name);			// Lycia莉西亞
		System.out.println(name2);			// Lycia莉西亞Chen
		System.out.println(name.length());	// 8
		String name3 = name.replace('a', 'A');
//		replace('a', 'A') 尋找字元 a 並改成 A
		System.out.println(name3);			// LyciA莉西亞
		System.out.println("------");
		String s1 = new String("Lycia");
		String s2 = s1;
		System.out.println(s1 == s2);		// true
//		== 比較的是記憶體位址
		s2 = "Lycia";
//		s2 改為指向 常值池中的 "Lycia"
		System.out.println(s1 == s2);		// false
//		s1 是 new 出來的物件，和字串常值池是不同位址。
		System.out.println(s1.equals(s2));  // true
//		.equals()比較字串內容
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
}