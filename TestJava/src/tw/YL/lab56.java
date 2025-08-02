package tw.YL;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.apis.Student;

public class lab56 {
	
	/*
 		解序列化，把物件從檔案還原
	 */
	
// fin開啟byte檔，oin還原成物件，obj物件讀回並回傳Object型態，s1轉型成Student型態
	
	
	public static void main(String[] args) {
		try(FileInputStream fin = new FileInputStream("dir1/test.score");
			ObjectInputStream oin = new ObjectInputStream(fin)){
//			FileInputStream 開啟 lab55 存的序列化物件檔案
//			ObjectInputStream 包在 fin 外面，這樣可以讀回 Java 物件
//			ObjectInputStream：幫你把「byte 檔」 → 重新還原成 Java 物件，
//			只要class 符合，且有 implements Serializable就能還原
			
//			oin.readObject()會把檔案裡序列化的物件讀回，回傳Object(型態類別)
			Object obj = oin.readObject();
			
//			if (obj instanceof Student) {System.out.println("student");}
//			檢查一個物件 obj 是否是 Student 類別
//			()如果 obj 是 Student 類別的物件（或繼承自 Student 的物件），就回傳 true
//			instanceof ：Java中用來檢查物件的型別

			Student s1 = (Student)obj;
//			需要強制轉型，這樣才能使用 Student 方法
			
			System.out.println(s1.sum());
			System.out.println(s1.avg());
			System.out.println(s1.getBike().getSpeed());
			
			
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
	
