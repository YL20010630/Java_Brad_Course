package tw.Test;

public class test_02_foreach {

	/*
	 	練習題 2：陣列與 for-each
	 	
		請寫一個程式：
		建立 int[] nums = {3, 7, 2, 5, 8}
		用 for-each 印出每個元素
		計算總和並印出

	 */
	
	/*
		Iterator是迭代，Integer是整數類別
		Iterator<類別> 單 = 多.iterator();
		搭配while(單.hasNext()){印出 單.next() }
	 */
	
	
	public static void main(String[] args) {
		int[] nums = {3, 7, 2, 5, 8};
//		計算總合
		int sum = 0;
		
		for(int num : nums) {
//			System.out.println(num);
//			num +=;		// 錯誤
//			num += num;		// 錯誤，6|14|4|10|16
			sum += num;
		}
		System.out.println("總和: "+sum);
//		要放在迴圈外才不會每加一次都印出來

	}

}
