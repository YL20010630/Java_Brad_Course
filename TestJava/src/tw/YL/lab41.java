package tw.YL;

import java.io.File;
import java.io.IOException;


public class lab41 {

	public static void main(String[] args) {
		File f1 = new File("c:\\lab\\Java\\dir1");
//		if(!f1.exists()) {		// 檢查這個路徑是否存在，不存在就執行
			try {
				if(f1.createNewFile()) {		// 建立一個檔案
					System.out.println("OK");
				}else {
					System.out.println("XX");
				}
				System.out.println("OK2");
			}catch (IOException e) {
				System.out.println(e);
			}
//		}
	}

}
