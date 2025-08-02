package tw.YL;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class lab53 {

	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader("dir1/file1.txt");
//			這邊用FileReader是文字流，自動一邊讀檔一邊幫你解碼成char字元，不像FileInputStream是以byte位元組處理
			
			
			int c;
			while ((c = reader.read()) != -1) {
//			read() 也是回傳 int
				System.out.print((char)c);		// 所以這邊從int轉成char
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}