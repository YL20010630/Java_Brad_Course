package tw.YL;

import tw.apis.Bike;

public class lab23 {
	
	public static void main(String[] args) {
		String s1 = "lab";
		String s2 = "lab";
		String s3 = new String("lab");
		String s4 = new String("lab");
		
		int a = 10;
		int[] n = {1, 2, 3, 4};
		Bike bike = new Bike();
		System.out.println(bike);		// 印出記憶體位置
		System.out.println(s3);			// lab

		
		
//		bike.upSpeed();bike.upSpeed();bike.upSpeed();bike.upSpeed();
//		System.out.println(bike);
		
		
		int x = 10, y = 10;
		System.out.println(x == y);		   		// true
		System.out.println(s1 == s2);		   	// true
		System.out.println(s3 == s4);			// false
		System.out.println(s1 == s3);		    // false
		System.out.println(s1.equals(s3));   	// true，只看字串
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
}