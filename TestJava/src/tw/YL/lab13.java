package tw.YL;

public class lab13 {

	public static void main(String[] args) {

	int[] a = new int[] {1, 2, 3, 4};
//	陣列a，建立一個int陣列，初始的四個元素是{1, 2, 3, 4}
	
	int[] b = {1, 2, 3, 4};
//	跟a一樣，只能在 宣告時就初始化 才能用
	
	int[] c;
	c = new int[] {1, 2, 3, 4};
//	宣告跟初始化分開寫，new int[]不能省略
	
	for (int v : c) {
		System.out.println(v);
	}
	
	
	
	}

}
