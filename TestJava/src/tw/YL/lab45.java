package tw.YL;

import java.io.File;

public class lab45 {
	/*
	 	絕對路徑/相對路徑/本路徑
	 */

	public static void main(String[] args) {
		File root = new File(".");
		System.out.println(root.getAbsolutePath());		// 本路徑C:\Users\皮\eclipse-workspace\TestJava\.
		
//		相對路徑
//		File dir1 = new File("./dir3");			// 創建dir3
		File dir1 = new File("dir4/dir5/dir6/dir7");		// 創建dir4裡有dir5...
		System.out.println(dir1.exists());		// 檢查檔案是否存在
		System.out.println(dir1.mkdirs());		// 建立目錄
		
	}

}
