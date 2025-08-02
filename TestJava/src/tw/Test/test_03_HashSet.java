package tw.Test;

import java.util.Arrays;
import java.util.HashSet;

public class test_03_HashSet {

	/*
		練習題 3：HashSet
//		HashSet 不重複且沒有順序性，是boolean型態
		
		請寫一個程式：
		
		建立 HashSet<String> names
		
		加入三個不同名字
		
		嘗試再加入一個重複的名字
		
		最後印出 names 的內容
		
		並用 for-each 走訪印出每一個


	 */
	
	

	
//	HashSet要在上面import
	public static void main(String[] args) {

//		HashSet <String> names = new HashSet();		// 錯誤
		HashSet <String> names = new HashSet<>();	
//		names.add("Anny").add("Betty").add("Cindy");
//		錯誤，HashSet的.add只能一個個加，因為回傳boolean，不是字串，無法鏈式寫法

		names.add("Betty");
		names.add("Cindy");
		names.add("Anny");
		names.add("Cindy");
		
//		一次加入多個
//		names.addAll(Arrays.asList("Anny", "Betty", "Cindy", "Cindy"));
		
		System.out.println(names);
		for(String name : names) {
			System.out.println(name);
		}

	}

}
