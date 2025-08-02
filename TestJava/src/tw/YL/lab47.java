package tw.YL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class lab47 {
	
	public static void main(String[] args) {
		File f1 = new File("dir1/file1.txt");
		long len = f1.length();
		try {
//			FileInputStream fin = new FileInputStream("dir1/file1.txt");		// 讀取檔案
			FileInputStream fin = new FileInputStream(f1);
			for(int i = 0; i<len; i++) {
				System.out.print((char)fin.read());
//				每讀取一個位元組，強制轉成char再印出
//				中文會亂碼，因為中文要2~3個位元組
				
			}
			
			
			System.out.print((char)fin.read());
			System.out.print((char)fin.read());
			System.out.print((char)fin.read());
			
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
