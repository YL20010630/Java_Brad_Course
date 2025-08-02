package tw.YL;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.apis.Student;

public class lab55 {
	
	/*
	 	序列化，把物件存成檔案
	 */

	public static void main(String[] args) {
		Student s1 = new Student("Amy", 76, 87, 32);
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		System.out.println(s1.getBike().upSpeed().upSpeed().upSpeed().upSpeed().getSpeed());
		
		try {		// 序列化(物件寫進檔案)
			FileOutputStream fout = new FileOutputStream("dir1/test.score");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
//			fout：負責檔案輸出
//			oout：幫你把「物件」轉成可以存到檔案的格式
//			上面串在一起只要close一個
			
			oout.writeObject(s1);		// 把 s1 序列化寫進檔案
			fout.flush();
			fout.close();
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e);
		}

		
	}
	

}
