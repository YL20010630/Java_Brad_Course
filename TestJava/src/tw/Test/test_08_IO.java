package tw.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.WriteAbortedException;
import java.lang.module.FindException;
import java.util.spi.LocaleNameProvider;

public class test_08_IO {
	
	/*
	 	I/O 輸入/輸出
	 	FileOutputStream → 寫到檔案
	 	FileInputStream → 從檔案讀出
	 	
	 	FileReader = 純文字檔 + 系統編碼
//		InputStreamReader = 可以自己指定編碼
//		但大多時候讀一般文字檔用 FileReader 就夠，
//		如果需要手動設定編碼，就會改用 InputStreamReader
	 	
	 */
	
	/*
	 * 
	 	練習：文字檔複製程式
	 	🟢 任務說明
		寫一支 Java 程式
		從「source.txt」讀入文字
		複製到「copy.txt」
		用 BufferedReader 和 BufferedWriter
		一行一行讀入再寫出
		
		寫一個檔案 hello.txt，裡面寫入 Java is powerful!
		再讀回這個檔案並顯示在主控台
		就用上面 FileOutputStream / FileInputStream
		
	 */

	public static void main(String[] args) {
		
//		創一個檔裡面寫字
//		String msg = "Test, 檔案文字";
//		byte[] bufmsg = msg.getBytes();
//		
//		try {
//			FileOutputStream fout = new FileOutputStream("dir2/msg.txt");		// 寫檔
//			fout.write(bufmsg);
//			fout.write("新增文字".getBytes());
//			fout.write(97);
//			fout.flush();
//			fout.close();
//			System.out.println("新增成功");
//					
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
//		byte讀檔，一次讀一個字
		try {
			FileInputStream fin = new FileInputStream("dir2/msg.txt");		// 讀檔
			FileOutputStream fout = new FileOutputStream("dir2/copy.txt");	// 寫檔
//			System.out.println(fin);		// 錯誤，印出檔案要用read()
//			fin.read();		// 錯誤，要用while迴圈搭配才能一字一段讀出來
			
			int c;
			while((c = fin.read()) != -1) {
				fout.write(c);
				System.out.print((char)c);
			}
//			fout.write(fin);		// 錯誤，write只能寫byte或byte[]

			fin.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		byte讀檔，一次讀全部
		File f1 = new File("dir2/msg.txt");
		byte[] buf = new byte[(int)f1.length()];		// new byte[3]
		try {
			FileInputStream fin = new FileInputStream(f1);
			FileOutputStream fout = new FileOutputStream("dir2/copy.txt");
			
			int len;
			while((len = fin.read()) != -1) {
				fout.write(len);
			}
			fin.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		文字讀檔，FileRead、BufferedRead
		try {
			FileReader fr = new FileReader(f1);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
//			while((line = reader.read()) != null) {		// 錯誤
			while((line = br.readLine()) != null) {
//				br.write(line);
				System.out.println(line);
			}
			
//			若是每行前面加上該行是第幾行的數字
//			String line;
//			int lineNumber = 1;
//			while((line = br.readLine()) != null) {
//				System.out.println(lineNumber + ": " + line);
//				lineNumber++;
//			}
			
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
