package tw.YL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class lab49 {
	
//	一次讀取三個位元
	
	public static void main(String[] args) {
		File f1 = new File("dir1/file1.txt");
		byte[] buf = new byte[3];
		try {
			FileInputStream fin = new FileInputStream(f1);
			int len;
			while((len = fin.read(buf)) != -1) {
//			從檔案裡讀最多 3 個 byte，放到 buf，回傳「實際讀到的長度」給 len
				System.out.print(new String(buf, 0, len));		// 從0開始取長度
			}
			
			fin.close();
			System.out.println();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}

}
