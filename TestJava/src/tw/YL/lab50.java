package tw.YL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class lab50 {
	
	// 一次讀取全部長度
	
	public static void main(String[] args) {
		File f1 = new File("dir1/file1.txt");
		byte[] buf = new byte[(int)f1.length()];
		try {
			FileInputStream fin = new FileInputStream(f1);

			fin.read(buf);		// 讀取全部
			fin.close();
			System.out.println(new String(buf));
			System.out.println();
			System.out.println("OK");

		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
