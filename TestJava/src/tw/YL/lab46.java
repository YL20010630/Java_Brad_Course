package tw.YL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class lab46 {

	public static void main(String[] args) {
		String msg = "Hello, lab\n";
		byte[] buf = msg.getBytes();
//		先把字串轉成位元組陣列 buf
//		因為 FileOutputStream 只能寫 bytes
		
		try {
			
			FileOutputStream fout = new FileOutputStream("dir1/file1.txt",true);
//			建立一個檔案輸出串流
//			true 是把新的資料接在檔案後面，不會覆蓋原本的檔案內容
//			如果改成 false 或省略，就會預設覆蓋檔案
//			這裡加true能讓印在file1.txt的文字重複出現
			
			fout.write(buf);
			
//			fout.write(97);		// a
//			fout.write(98);		// b
//			fout.write(99);		// c
//			fout.write(100);	// d
			
			fout.flush();		// 強制現在馬上把記憶體裡的資料都寫進檔案，避免程式掛掉資料會沒寫進去
			fout.close();		// 把檔案關掉，同時也會自動 flush
			System.out.println("OK");
				
			}catch (Exception e) {		// 所有錯誤都抓
				System.out.println(e);
			}

//		}catch (FileNotFoundException e) {
//			e.printStackTrace();
//			印出完整錯誤路徑
//		}catch (IOException e) {		// 檔案相關錯誤
//			System.out.println(e);
//			只印出錯誤訊息

		
		
	}

}


/*
 	FileNotFoundException，是 IOException 的子類別，意思是找不到檔案就丟這個錯誤
 	IOException主要針對 輸入輸出作業（I/O）(檔案)可能發生的錯誤
 */
