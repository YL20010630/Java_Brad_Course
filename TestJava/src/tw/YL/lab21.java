package tw.YL;

public class lab21 {

	public static void main(String[] args) {
		lab211 Obj1 = new lab211(0);
		lab212 Obj2 = new lab212();
//		lab213 Obj3 = new lab213();
//		lab213 Obj3 = new lab213(2);
		lab213 Obj3 = new lab213(2.1);

	}

}

class lab211 extends Object {
//	void lab211(int a) {     // 錯誤
//	建構式沒有傳回值型別
//	void是方法，所以建構式不能寫void	
	
//	lab211這個類別定義了一個有傳參數的建構式
	lab211(int a) {
//	int a 是接收參數
//	有參數的建構式，強制呼叫時一定要傳 int
//		super();
		System.out.println("lab211(int)");
		
	}
}

class lab212 extends lab211 {
//	無參數建構式
	lab212(){
//		super();    //	呼叫父類別的建構式
		super(1);
//		明確呼叫父類別 lab211 的建構式（一定要給 int）
		
		System.out.println("lab212()");			// lab21(int)
	}
}
//	因為父類別 lab211 沒有提供無參數建構式，所以這裡一定要用 super(1) 否則會錯
//	super(...) 必須寫在子類別建構式的第一行
//	有參數， 子類別一定要寫 super(值)

	
class lab213 extends lab212 {
	lab213(){
		super();  		// 可寫可不寫，Java 會自動補上
//		呼叫父類別 lab212()，而 lab212() 又呼叫 lab211(1)
//		建構順序為 lab211(int) -> lab212() -> lab213()
//		呼叫順序為 lab213() → lab212() → lab211(1)
		System.out.println("lab213()");
		}
	lab213(int a) {
//		super();  		// 可寫可不寫，Java 會自動補上    // 呼叫 lab212()
//		this(2.1);		// 錯誤
		this();			// 呼叫自己無參數建構式 lab213()
//		若改成this(2);，就是呼叫 自己，會進入無限遞迴
//		super(); 跟 this(); 不能同時出現在建構式當中，且必須是第一行
//		呼叫順序為 lab211(int) -> lab212() -> lab213() -> lab213(int)
		System.out.println("lab213(int)");
		
	}
	lab213(double a) {
		this(2);		
// 		this(2); 是 int ，所以呼叫上面那個 int 版本建構式 lab213(int a)
//		若改為this(2.1) 是 double → 呼叫 lab213(double a) 本身，進入無限遞迴
//		呼叫順序為 lab213(double) ➝ lab213(int) ➝ lab213() ➝ lab212() ➝ lab211(1)
//		this(2.1);
//		會呼叫 lab213(double a) 建構式，因為 2.1 是 double
//		在 lab213(double a) 裡面直接寫 this(2.1); 會呼叫自己（會造成無限遞迴）且會編譯錯誤
		System.out.println("lab213(double)");
		
	}
}
		

//	（因為 lab212 呼叫了 super(1)）
//	 所以先執行 lab211(int a)，然後執行 lab212()，最後執行 lab213()

//呼叫點： new lab213();
//呼叫流程：lab213() → lab212() → lab211(int)
//印出：
//lab211(int)
//lab212(int)
//lab213(int)
//
//呼叫點： new lab213(int a);
//呼叫流程：lab213(int) → lab213() → lab212() → lab211(int)
//印出：
//lab211(int)
//lab212(int)
//lab213(int)
//lab213(int)
//
//呼叫點： new lab213(double a);
//呼叫流程：lab213(double) → lab213(int) → lab213() → lab212() → lab211(int)
//印出：
//lab211(int)
//lab212(int)
//lab213(int)
//lab213(int)
//lab213(int)




//	1. 所有class一定有建構式
//	-> Java 會自動呼叫父類別的無參數建構式（super()）
//	-> 如果父類別沒有無參建構式，子類別建構式就必須明確寫 super(參數)

//	2. 建構式 => 將祖孫八代完成初始化





