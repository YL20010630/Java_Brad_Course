package tw.YL;

public class lab44 {

	public static void main(String[] args) {
		lab441 obj = new lab441();
		try {
			obj.m1();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
//		try {
//		    obj.m1();
//		} catch (Exception e) {
//		    System.out.println("我有處理例外！");
//		}

		

	}
}

//	寫throws Exception，是告訴編譯器「我這裡可能會丟 Exception，請呼叫端準備好 try/catch」

class lab441{
	void m1() throws Exception{
		m2();
	}
//	呼叫m2()，並宣告throws Exception
	void m2() throws Exception{
			
//		空的，什麼都沒做，也宣告 throws Exception，但是沒有真的拋例外
		}
	void m3() throws Exception{
		System.out.println("m3()");
	}
}


//class lab441{
//	void m1() throws Exception{
//		throw new Exception("發生問題");  // 有丟例外
//	}
//}
