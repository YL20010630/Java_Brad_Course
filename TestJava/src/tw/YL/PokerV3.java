package tw.YL;

import java.util.Arrays;

public class PokerV3 {

	public static void main(String[] args) {
		final int nums = 52;
		int [] poker = new int [nums];
		
//		洗牌
		for (int i = 0; i < poker.length; i++) poker[i] = i;

		for(int i = nums -1; i > 0; i--) {
			int r = (int)(Math.random()*(i+1));
			// poker[r] <=> poker[i]
			int temp = poker[r];
			poker[r] = poker[i];
			poker[i] = temp;
		}			
	
		for(int card: poker) {
			System.out.println(card);
		}
		System.out.println("---------");
		
		
		int[][]players = new int [4][13];
		for(int i = 0; i <  poker.length; i++) {
//			用 i 表示目前的牌第幾張，每跑一次迴圈，就把第 i 張牌分給一位玩家
			players[i%4][i/4]= poker[i];

//			i % 4	第幾位玩家（0~3） → 橫排
//			i / 4	該玩家拿的第幾張牌 → 直排
//			假設 i = 5，那麼：
//			5 % 4 = 1 → 分給第 2 位玩家（索引值是 1）
//			5 / 4 = 1 → 他收到的是第 2 張牌（索引值是 1）
//			所以 players[1][1] = poker[5]，表示第 2 位玩家收到第 2 張牌是第 5 張洗好的牌。
		}
		
		String [] flowers = {"黑桃", "紅心", "方塊", "梅花"};
		String [] values = {"A", "2", "3", "4", "5", "6",
				"7", "8", "9", "10", "J", "Q", "K"};
		
		for(int[]player : players) {
			System.out.print("player: ");
			Arrays.sort(player);
			for(int card: player) {
//				System.out.print(card + "\t");
				System.out.print(flowers[card/13] + values[card%13] + "\t");
//				card / 13 決定是哪個花色（每 13 張牌換一次花色），
//				card % 13 決定是什麼數字（點數）
			}
			System.out.println("");
		}
		
		

	}

}
