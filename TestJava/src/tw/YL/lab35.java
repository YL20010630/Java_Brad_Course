package tw.YL;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class lab35 {

	public static void main(String[] args) {
		HashSet<Integer> lottery = new HashSet<>();
//		new HashSet<>() → 建立一個新的 HashSet 物件
//		建立一個叫lottery的HashSet集合，裡面只能放整數(Integer)，並且這個集合不重複也不會保證順序
		
//		lottery.add(12);
//		lottery.add(123);
		while (lottery.size() < 6) {
//		到第五次結束就有五個數字了，第六次開始判斷size還是只有五個所以再增加一個數字，共六個數字
			lottery.add((int)(Math.random()*49+1));
		}
		System.out.println(lottery);
//		lottery 是一個集合物件
		System.out.println("-----");
		
		
		Iterator<Integer> it = lottery.iterator();
//		Iterator 迭代寫法，跟foreach差不多，用 Iterator 走訪每個元素
//		Iterator 有更細的控制權，例如可以it.remove() 刪掉目前元素或在任意時候停止走訪
//		迭代器 it 會「指向」這個集合裡的元素
		
		while (it.hasNext()) {
//		判斷「還有沒有下一個元素可以走訪」，有true，沒有false
			System.out.println(it.next());
//			it.next() → 取得目前「游標」的下一個元素，並且把游標往下移
		}
		System.out.println("-----");
		
		for (Integer v : lottery) {
//		直接用 foreach 迭代
			System.out.println(v);
		}
		
		
		
	}
}
