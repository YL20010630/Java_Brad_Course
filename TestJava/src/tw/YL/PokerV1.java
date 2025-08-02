package tw.YL;

public class PokerV1 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
		int [] poker = new int [10];
		
//		將變數宣告在外面
		boolean isRepeat;
		int rand;
		
//		洗牌
		for (int i = 0; i < poker.length; i++) {
			
//			poker[i] = (int)(Math.random()*52);
//			System.out.println(poker[i]);   // 有重複的數字

			do {
				rand = (int)(Math.random()*10);
			
	//			檢查是否重複
				isRepeat = false;
				for(int j = 0; j < i; j++) {
					if (rand == poker[j]) {
	//					重複了
						isRepeat = true;
						break;
					}
				}
			} while (isRepeat);
//			只要重複，就重新再抽
			
			poker[i] = rand;
			System.out.println(poker[i]);
			
		}
		
//		do...while  先執行，再判斷條件。至少執行一次
		
		System.out.println("---------");
		System.out.println(System.currentTimeMillis() - start);
//		耗費的時間
		
//		發牌
		
//		攤牌 + 理牌

		

		
		

	}

}
