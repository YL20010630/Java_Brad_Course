package tw.YL;

public class lab26 {

	public static void main(String[] args) {
		lab261.m2();
		lab261.m2();
		lab261.m2();
		
		lab261 obj1 = new lab261();
		lab261 obj2 = new lab261();
	}
}
class lab261 {
	{
		System.out.println("lab261{}");
		m1();
		m2();
	}
	static {
		System.out.println("lab261:static{}");
		m2();
	}
	lab261(){
		System.out.println("lab261()");
		m1();
	}
	void m1() {
		System.out.println("lab261:m1()");
	}
	static void m2() {
		System.out.println("lab261:static:m2()");
	}
}

/*
static {} 是 靜態區塊，只會在「第一次載入 class」時執行一次。
{} 是 物件區塊，每建立一次物件，就執行一次，而且會在建構式之前執行。
static 方法 可以用 類別名.方法() 直接呼叫，不需要物件，如 lab261.m2()。
非 static 方法 只能透過物件呼叫，如 obj1.m1()。

第一步. Java 會先載入 class lab261，執行其 static {}
static {
	System.out.println("lab261:static{}");   // 印出第一行
	m2();		// 印出第二行lab261:static:m2()
}

第二步. lab261.m2();呼叫三次
加上第一步驟，lab261.m2()會有四行

第三步. 建立lab261 obj1 = new lab261();  再建立lab261 obj2 = new lab261();
執行 物件區塊 {} => 印出lab261{} -> m1() -> m2()
每次用 new XXX() 建立物件時，{}就會執行一次，且會在建構式之前執行。
new lab261(); → 先跑 {} （物件區塊） → 再跑建構式 lab261()
 
m1、m2 是物件
m1() 代表「某個物件」的行為，所以只能在「物件存在時」才能呼叫。
m2() 是類別層級的功能，不需要建立物件，任何時候都能用 lab261.m2() 呼叫。
*/







