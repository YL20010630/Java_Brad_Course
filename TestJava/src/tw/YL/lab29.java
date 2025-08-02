package tw.YL;

public class lab29 {

	public static void main(String[] args) {
		lab291 obj1 = new lab291();
		lab291 obj2 = new lab292();
//		變數型別是父類 lab291，實際物件是 lab292，呼叫 obj2.m1() ➜ 會根據實際物件呼叫
		lab291 obj3 = new lab293();
//		父類型變數指向子類物件 ➜ 多型作用
		
//		lab292 是類別。
//		new lab292() 是物件（實體），用 lab292 類別建立的。
//		obj2 是變數，型別為 lab291，實際指向的是 lab292 物件。
		
		
		
		obj1.m1();
		obj2.m1();
		obj3.m1();
		lab292 obj4 = (lab292)obj2;
		obj4.m2();
		
//		obj2.m2()		// 不能用變數型別沒有的方法
//		obj2.m2() 是錯誤的，因為：obj2 的型別是 lab291，lab291 沒有 m2()
		
//		變數型別 = 你「可以呼叫」什麼方法			// 如lab291
//		物件類型 = 你「執行」的實際方法版本		// 如lab292
		
//		如果你把變數obj2想成「遙控器」，物件new lab292()想成「電器」，
//		你用這支遙控器obj2只能按它能按的按鈕m1()（變數型別lab291決定），
//		但電器物件new lab292()會根據自己型號（物件類型lab292）做出對應反應。


		
		
		System.out.println(obj2 == obj4);
//		指向同一個物件
		System.out.println(obj2 instanceof lab293);
		
	}

}


//	*****多型

class lab291 {
	void m1() {System.out.println("lab291:m1()");}
}
class lab292 extends lab291 {
	void m1() {System.out.println("lab292:m1()");}
	void m2() {System.out.println("lab292:m2()");}
}
class lab293 extends lab291 {
	void m1() {System.out.println("lab293:m1()");}
}
