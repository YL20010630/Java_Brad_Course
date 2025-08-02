package tw.YL;

public class PokerV2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int [] poker = new int [52];
		
//		洗牌
		for (int i = 0; i < poker.length; i++) {
			
//			poker[i] = (int)(Math.random()*52);
//			System.out.println(poker[i]);   // 有重複的數字
			
//			檢查是否重複
			boolean isRepeat = false;
			int rand = (int)(Math.random()*52);
			for(int j = 0; j < i; j++) {
				if (rand == poker[j]) {
//					重複了
					isRepeat = true;
					break;
				}
			}
		
			if(!isRepeat) {
				poker[i] = rand;
				System.out.println(poker[i]);
			} else {
				i--;
			}
		}
		
//		i 是放新牌的索引，j 是檢查所有「之前放好的牌」
		
		
		System.out.println("---------");
		System.out.println(System.currentTimeMillis() - start);
//		耗費的時間
		
//		發牌
		
//		攤牌 + 理牌

		

		
		

	}

}
