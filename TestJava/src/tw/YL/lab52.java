package tw.YL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class lab52 {
	
	/*
 	檔案複製，
	從 dir1/圖片2.jpg → 複製到 dir2/圖片2.jpg
	一次讀全部，馬上寫 1 byte，完成後結束，並且印出花了幾毫秒。
 */

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		File source = new File("dir1/圖片2.jpg");
//		建立一個 File 物件代表來源檔
//		byte[] buf = new byte[4096];
		byte[] buf = new byte[(int)source.length()];
//		建立一個緩衝區，一次就足夠容納整個檔案的容量
		try(FileInputStream fin = new FileInputStream(source);) {
//		自動 close
			FileOutputStream fout= new FileOutputStream("dir2/圖片21.jpg");
//			準備輸出檔案
				
//			fin.read(buf);		// 讀完回傳實際讀到的長度
//			fout.write(buf);	// 只寫讀到的那幾個位元組
//			fout.flush();		// 強迫把緩衝區資料真正寫進檔案
				
			int len;
			while((len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			System.out.println("Finish");
			System.out.println(System.currentTimeMillis() - start);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
