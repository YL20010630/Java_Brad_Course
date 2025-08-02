package tw.YL;

public class lab33 {

	public static void main(String[] args) {
		String test = "1224";
		if (test.matches("[0-9]{4}")) {
//		判斷字串 test 是否剛好是 4 個數字字符（0~9）
			long count = test.chars().filter(c -> c == '2').count();
//			test.chars() 是一個方法，將字串轉成整數流，用於提取字符串 test 中的所有字符，並將它們作為一個字符數組返回
//			字串轉成整數流(字元的 Unicode 編碼)：'1' -> 49	，'2' -> 50，'2' -> 50，'4' -> 52

//			.filter(c -> c == '2') 過濾留下字元是'2'的項目
//			.count() 計算 '2' 出現的次數。
			System.out.println(count);
			System.out.println("----");
			test.chars().forEach(ch -> System.out.println((char)ch));
//			將字串轉成的整數流用foreach逐一印出每個字元再強制轉型回char
//			ch 代表每次取出的一個 int 數字(Unicode 編碼)
//			(char) ch 把數字轉回字元
			
		}else {
			System.out.println("XX");
		}
	}

}
