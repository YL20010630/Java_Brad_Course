package tw.YL;

public class lab06 {

	public static void main(String[] args) {
//		int score1 = 59;
//		if(score1 >= 60) {
//			System.out.println("Pass");
//		} else {
//			System.out.println("Down");
//		}
		
		double temp1 = Math.random();   // 0.0 ~ 1.0
		System.out.println(temp1);
		
		int score2 = (int)(temp1*101);   // 0 ~ 100.99999，用int 取整數
		// 從0開始共101個整數值之亂數
		System.out.println(score2);
		if(score2 >= 60) {
			System.out.println("Pass");
		} else {
			System.out.println("Down");
		}
		
		int dice = (int)(temp1*6) +1;   // 從1開始共6個整數之亂數
		System.out.printf("dice = %d\n", dice);
		System.out.println("dice = " + dice);

		
		
//		double temp2 = Math.random()*100;
//		System.out.println(temp2);
		
		if(score2 >= 90) {
			System.out.println("A");
		} else if(score2 >= 80) {
			System.out.println("B");
		} else if(score2 >= 70) {
			System.out.println("C");
		} else if(score2 >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
		
		if(score2 >= 90) {
			System.out.println("A");
		} else {
			if(score2 >= 80) {
				System.out.println("B");
			} else {
				if(score2 >= 70) {
					System.out.println("C");
				} else {
					if(score2 >= 60) {
						System.out.println("D");
					} else {
						System.out.println("F");
					}
				}
			}
		}
		
		

	}

}
