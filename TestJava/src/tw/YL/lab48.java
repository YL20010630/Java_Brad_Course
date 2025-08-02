package tw.YL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class lab48 {
	
//	一次讀取一個位元
	
	public static void main(String[] args) {
		File f1 = new File("dir1/file1.txt");
		try {
			FileInputStream fin = new FileInputStream(f1);		// 檔案路徑
			
//			一次多讀（byte[]）比較快		// lab49會寫
//			int len;
//			while((len = fin.read(buf)) != -1) {
//			從檔案裡讀最多 3 個 byte，放到 buf，回傳「實際讀到的長度」給 len
//				System.out.print(new String(buf, 0, len));		// 從0開始取長度，轉成字串印出
			
//			一次一個（int）比較單純，fin.read()的回傳值型態是int
			int c;
			while ( (c = fin.read()) != -1) {		// 一次讀一個byte
//			每次讀取 buf，只要還有資料（len != -1），就繼續讀
				System.out.print((char)c);			// 轉成char字元印出
			}
			fin.close();
			System.out.println();
			System.out.println("OK");

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
