package tw.YL;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class lab54 {

	public static void main(String[] args) {
		try(FileReader reader = new FileReader("dir1/ns1hosp.csv");
				BufferedReader br = new BufferedReader(reader)){
//			FileReader：打開文字檔
//				BufferedReader：包一層緩衝區，一次讀比較大塊資料，效能比較好

			
//			FileInputStream fin = new FileInputStream("dir1/ns1hosp.csv");
//				InputStreamReader isr = new InputStreamReader (fin);
//					BufferedReader br = new BufferedReader(isr)){

//			FileReader = 純文字檔 + 系統編碼
//				InputStreamReader = 可以自己指定編碼
//			但大多時候讀一般文字檔用 FileReader 就夠，
//			如果需要手動設定編碼，就會改用 InputStreamReader
			
			
			
			String line;
			while ((line = br.readLine()) != null) {
//			br.readLine() 一次讀一行，回傳一行文字 (字串)，直到 null 表示檔案結束

				String[] row = line.split(",");
//				System.out.println(line);
//				System.out.println(row[2]);
				System.out.printf("%s: \t %s \n", row[2], row[7]);		// %d整數，%s字串
			}
		} catch (Exception e) {
			System.out.println(e);
		}


	}

}
