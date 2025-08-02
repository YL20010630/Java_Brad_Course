package tw.YL;

import tw.apis.Bike;

public class lab17 {
	 
//	物件導向

	public static void main(String[] args) {
		Bike b1 = new Bike();   // 完成初始化
//		用類別產生物件，建立 Bike 類別的一個物件（instance），叫做 b1
		Bike b2 = new Bike();
		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		System.out.println(b2.getSpeed());
		System.out.println("---");
		
//		while(b1.speed <20) {
//			b1.upSpeed();
		//System.out.println(b2.speed);
		//System.out.println(b1.speed);
//		}
		
	}

}



//設計物件導向先設計類別再設計屬性再設計物件