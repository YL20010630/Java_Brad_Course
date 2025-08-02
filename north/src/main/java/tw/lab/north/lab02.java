package tw.lab.north;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import tw.lab.entity.Employee;


//	 Java 反射（Reflection）的基本使用


public class lab02 {

	public static void main(String[] args) {
		try {
//			取得 class 物件 (反射)
			Class<?> cla =  Class.forName("tw.lab.north.lab021");
			
//			建立 lab021 類別的新實例
			Object obj = cla.getDeclaredConstructor().newInstance();
			
//			得該 class 的所有公開方法 (包含繼承來的方法)
			Method[] ms = cla.getMethods();
			for (Method mm : ms) {
				System.out.println(mm.getName()); 		// 印出方法名稱
			}
			
//			取得名稱為 "m1" 的方法
			Method method1 = cla.getMethod("m1");
//			呼叫 m1 方法（無參數）於 obj 物件上
			method1.invoke(obj);
			
//			取得私有欄位 "a"
			Field field = cla.getDeclaredField("a");
//			設置私有欄位可存取（因為預設私有不能直接操作）
			field.setAccessible(true);
//			修改欄位 a 的值為 100，物件是 obj
			field.set(obj, 100);
			
			method1.invoke(obj);
			System.out.println("----");
			
//			呼叫泛型方法 createObject 產生 Employee 物件
			Employee e = createObject(Employee.class);
			e.setTitle("lab");
			System.out.println(e.getTitle());
			
//			呼叫泛型方法 createObject 產生 lab021 物件
			lab021 bb = createObject(lab021.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	泛型方法：用來建立 Class<T> 的物件實例
	static <T> T createObject(Class<T> cla) throws Exception {
		return cla.getDeclaredConstructor().newInstance(); 
	}
//	返回原物件
	static Employee setEmployee(Employee e, String sql) {
		return e;
	}

}

class lab021 {
	private int a;
	public void m1() {
		a++;
		System.out.println("lab021:m1():" + a);
	}
	private void m2() {
		System.out.println("lab021:m2()");
	}
}




//	用反射動態取得類別資訊與建立物件
//	Class.forName("tw.lab.north.lab021") → 載入指定類別
//	getDeclaredConstructor().newInstance() → 建立該類別新物件
//	
//	取得方法清單並列出方法名稱
//	getMethods() 會列出該類別所有公開方法（包含繼承的）
//	
//	呼叫公開方法 m1()
//	getMethod("m1") 找到 m1 方法
//	invoke(obj) 呼叫方法，會使 a++ 並印出
//	
//	透過反射取得並修改私有欄位
//	getDeclaredField("a") 找私有欄位 a
//	setAccessible(true) 讓 private 欄位可以存取
//	field.set(obj, 100) 修改欄位值為 100
//	
//	再次呼叫 m1()，看到 a 從 100 開始累加
//	因為你改了欄位 a 的值，所以印出會是 101
//	
//	泛型方法 createObject
//	這個方法用來產生任意 class 的新物件，避免重複程式碼。
//	你用它來建立 Employee 和 lab021 物件。
//	
//	setEmployee 方法目前是空的
//	這個方法沒有實作任何邏輯，未來可用來根據 SQL 來設定 Employee 物件屬性。