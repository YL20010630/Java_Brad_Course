package tw.YL;

public class lab07 {

	public static void main(String[] args) {
		int year = 100;
		boolean isLeap;
		
		if (year %4 == 0 ) {
			if (year %100 == 0) {
				if (year %400 == 0) {
					isLeap = true;
				} else {
					isLeap = false;
				}
			} else {
				isLeap = true;
			}
		} else {
			// 平年
			isLeap = false;
		}
		System.out.printf("%d 年是%s年\n", year, isLeap?"閏":"平");
		
		
//		System.out.printf("%d 年是閏年", year);
		
//		閏年可以被4整除，但不能被100整除，可以被400%整除
//		int x.nextInt();
		if ((year %4 == 0 && year %100 != 0) || year %400 == 0)  {
			System.out.printf("%d 年是閏年", year);
		}else {
			System.out.printf("%d 年是平年", year);
		}
	
		
	}

}
