package tw.YL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class lab51 {
	
	/*
	 	檔案複製，
		從 dir1/圖片2.jpg → 複製到 dir2/圖片2.jpg
		一次讀 1 byte，馬上寫 1 byte，完成後結束，並且印出花了幾毫秒。
	 */
	
	

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try(FileInputStream fin = new FileInputStream("dir1/圖片2.jpg");
				FileOutputStream fout = new FileOutputStream("dir2/圖片2.jpg");) {
//		fin 是從 dir1/圖片2.jpg 讀檔
//		fout 是把檔案寫進 dir2/圖片2.jpg
			
			int b;
			while ( (b = fin.read()) != -1) {
				fout.write(b);
			}
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis() - start);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}