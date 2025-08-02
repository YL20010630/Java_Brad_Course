package tw.YL;

public class lab31 {

	public static void main(String[] args) {
		lab311 obj1 = new lab312();
//		若lab311為類別則原應執行lab311再執行lab312
//		因Brad311是介面，不會「執行」，只是限制「可用的方法」
//		再執行 Brad312，沒印出任何東西
		
		lab311 obj2 = new lab313();		// 以此類推沒印出東西
		lab314 obj3 = new lab312();		// 以此類推沒印出東西
		
		obj1.m1();
//		執行obj1的實作類別lab312的m1
		
		obj3.m3();
//		執行obj3的實作類別lab312的m3
		
	}
}

//	void m1(); 是「介面中的方法宣告」，有這個方法，但還沒寫內容，請後面的人實作
//	public void m1() { ... } 是「類別中實作的方法」，真的去寫這個方法的內容


interface lab311 {		// （介面）
	void m1();
	void m2();
}
class lab312 extends Object implements lab311, lab314{		// （類別）
//	同時實作 lab311 與 lab314，所以必須實作這兩個介面所有方法
	public void m1() {System.out.println("312m1");}  // 來自 lab311
	public void m2() {System.out.println("312m2");}  // 來自 lab311
	public void m3() {System.out.println("312m3");}  // 來自 lab314
	public void m4() {System.out.println("312m4");}  // 來自 lab314
}
class lab313 implements lab311{		// （類別）
//	只實作 lab311，所以只要寫 m1() 和 m2() 就好
	public void m1() {System.out.println("313m1");}
	public void m2() {System.out.println("313m3");}
}
interface lab314 {		// （介面）
	void m3();
	void m4();
}
interface lab315 extends lab311, lab314 {		// （介面延伸介面）
//	lab315 是複合介面，它整合了 lab311 + lab314 + 自己的 m5 和 m6
	void m5();
	void m6();
}
class lab316 implements lab315 {		// （實作 lab315）
//	因為 lab315 繼承了三個介面共六個方法，這個類別也要全都實作
	
	@Override
	public void m1() {
		// TODO Auto-generated method stub
		System.out.println("316m1");
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("316m2");
	}

	@Override
	public void m3() {
		// TODO Auto-generated method stub
		System.out.println("316m3");
	}

	@Override
	public void m4() {
		// TODO Auto-generated method stub
		System.out.println("316m4");
	}

	@Override
	public void m5() {
		// TODO Auto-generated method stub
		System.out.println("316m5");
	}

	@Override
	public void m6() {
		// TODO Auto-generated method stub
		System.out.println("316m6");
	}

	
}