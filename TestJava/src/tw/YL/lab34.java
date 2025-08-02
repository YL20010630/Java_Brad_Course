package tw.YL;

import java.util.HashSet;

import tw.apis.Bike;

public class lab34 {


	public static void main(String[] args) {
		HashSet set = new HashSet();
//		Set是介面，HashSet是實作Set的類別
//		宣告一個 HashSet，裡面可以放任何型別(字串、物件、數字、布林通通可以)
//		Set特性：不重複、沒有順序性
//		這是原始型態寫法，泛型<>寫法則是：HashSet<Integer> lottery = new HashSet<>();
		

		set.add("lab");
		set.add(new Bike());
		set.add(123);	// int => auto-boxing => Integer
//		123，因為是 int，會自動轉成 Integer
		set.add(12.3);	// double => Double
		System.out.println(set.size());
		set.add(123);		// 已經有Integer 123，不會再重複放入
		set.add("lab");
		set.add(true);
		System.out.println(set.size());
		System.out.println(set);
		
//		HashSet雖然理論上不固定，但同一環境(機器、版本等)就會得到一樣的bucket分配 → 所以順序通常還是「看起來固定」的
//		記住 HashSet 永遠不能依賴「順序」，因為一旦環境不同就可能跑掉
		
	}


}

/*
	Collection<E>	
		=> Set	處存的東西都是物件型態，所以123、12.3都被包成Integer與Double
			->	不重複
			->	沒有順序性
		=>	List
			->	可重複
			->	有順序性
*/

/*
	int 是基本型別，只能存放整數，不能是物件
	Integer 是包裝類別，是一個「物件」類型，可以包含整數，也可以使用集合、泛型或 null 判斷等功能
	
	像 HashSet<Integer> 這種泛型，不能用int(因為泛型只能放物件)，所以必須用Integer
	像 HashSet<Integer> s = new HashSet<>();		因為 HashSet 只能放「物件」，所以一定要寫<Integer>
*/