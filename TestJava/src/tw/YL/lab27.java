package tw.YL;

public class lab27 {

	public static void main(String[] args) {
		lab271 obj1 = new lab271();
//		宣告一個名為 obj1 的變數，型別是 lab271，呼叫建構子 lab271()
		
		System.out.println(obj1.i);
		System.out.println(lab271.j);
			
		lab271 obj2 = new lab271();
//		又建立了一個新的物件 → 是全新的 lab271()記憶體，呼叫建構子 lab271()
		System.out.println(obj2.i);
		System.out.println(lab271.j);
			
		lab271 obj3 = new lab271();
//		再建立一個新的物件  又執行一次建構子
		System.out.println(obj3.i);
		System.out.println(lab271.j);
	}
	
}

class lab271 {
	int i;
	static int j;
	lab271(){
		i++;
		j++;
	}
}


/*
int i   是「實體變數」，每次 new XXXXX() 都會重新產生一個新的 i。用物件存取，如 obj1.i。
static int j  是「類別變數（靜態變數）」： 整個 class 共用一個 j。用類別名稱存取，如 lab271.j
*/