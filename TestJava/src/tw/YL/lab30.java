package tw.YL;

public class lab30 {

//	implements跟extends很像
//	extends	只能繼承一個父類別，implements可以實作多個介面（逗號分隔）
	
	public static void main(String[] args) {
//		lab301 obj1 = new lab301();
//		abstract是一個抽象類別，不能直接用new建立物件
		
		lab301 obj1 = new lab302();
		lab301 obj2 = new lab303();
//		每次new都會呼叫建構式lab301()
//		先建立lab302，自動呼叫lab301()，再執行lab302()
		
		obj1.m3();		// lab302:m3()
//		呼叫lab302實作的m2
		
		obj2.m3();		// lab302:m3()
//		呼叫lab302實作的m2
				
		lab301 obj3 = new lab303() {
//		先執行父類別建構式lab301再執行子類別建構式lab303
			void m3() {
				System.out.println("lab303:m3()");
			}
		};
		obj3.m3();
//		執行實際子類別lab303的m3方法
	}
}
		abstract class lab301 {
			lab301(){System.out.println("lab301()");}
			void m1() {}
			void m2() {}
			abstract void m3();
		}
		class lab302 extends lab301 {
			void m3() {System.out.println("lab302:m3()");}
		}
		class lab303 extends lab301 {
			void m3() {System.out.println("lab303:m3()");}
		}