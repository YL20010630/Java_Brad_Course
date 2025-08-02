package tw.YL;

import tw.apis.Bike;
import tw.apis.TWId;

public class lab25 {
	public static void main(String[] args) {

//		System.out.println("isRightID(String)");
//		return true;
	
//		System.out.println(Math.random());
		System.out.println(TWId.isRightID("B123456789"));		// 先印出11，再印出false
		System.out.println(Math.PI);
		System.out.println("----");
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId('B');
		TWId id4 = new TWId(true, 'A');
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
//		每個 TWId 建構子內，都會呼叫 isRightID，isRightID 內部會印出 a12（字母轉換數字）
		
//		TWId id5 = TWId.createTWId("A123456787");
//		if (id5 != null) {
//			System.out.println(id5.getId());
//		}else {
//			System.out.println("xxxxx");
//		}
		
		
		TWId id5;
		try {
			id5 = TWId.createTWId("A123456787");
			System.out.println(id5.getId());
		}catch (Exception e) {
			System.out.println(e);
		}

	
	}


}
