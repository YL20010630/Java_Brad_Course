package tw.YL;

public class lab08 {

	public static void main(String[] args) {
		
//		 Scanner scanner = new Scanner(System.in);
//	        System.out.print("請輸入月份（1~12）：");
//	        int month = scanner.nextInt(); // 讀取使用者輸入的數字
	        
		int month = 6;
		int days;
//		int days = -1     // 也可以先給賦值

		switch(month) {
			case 1, 3, 5, 7, 8, 10, 12:
				days = 31;
				break;
			case 2:
				days = 28;
				break;
			case 4, 6, 9, 11:
				days = 30;
				break;
			default:
				days = -1;
//				意思是：當 month 不符合任何 case 時，因days沒有賦值，所以讓 days = -1;，確保變數有值，不會出錯。
		}
		
		System.out.printf("%d月有%d天", month, days);
		
		
		
		
	}

}
