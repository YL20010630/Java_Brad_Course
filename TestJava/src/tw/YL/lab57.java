package tw.YL;

import java.io.FileInputStream;
//	讀取位元組的檔案

import java.io.FileOutputStream;
//	將位元組寫入檔案

import java.io.ObjectInputStream;
//	物件解序列化工具，包在FileInputStream外面

import java.io.ObjectOutputStream;
//	物件序列化工具，包在FileOutputStream外面

import java.io.Serializable;
//	一個介面，告訴 JVM 這個物件可以被序列化

public class lab57 {
	
	/*
	 	序列化過程：
	 	建立一個物件obj，
	 	oout (ObjectOutputStream) 轉成byte位元組，
	 	fout (FileOutputStream) 將位元組存進檔案。
	 	
	 	執行序列化：oout.writeObject(obj);	
	 			(obj)		oout				.writeObject
	 		將	物件			位元組化		並		寫成檔案
	 	
	 	
	 	解序列化過程：
	 	fin (FileInputStream) 讀取byte位元組檔案，
	 	oin (ObjectInputStream) 將位元組還原成物件，
	 	最後obj2就會是回傳的 Object型態的物件。
	 	
	 	執行解序列化：Object obj2 = oin.readObject();
	 						物件  = 還原.讀取的檔案
	 			.readObject()		oin			obj2
	 		將	讀取的位元組檔案		還原		成	物件
	 */
	
	
	

	public static void main(String[] args) {
		lab573 obj = new lab573();
//		建立一個 lab573 物件，並印出lab571 | lab572 | lab573
		
//		序列化
//		Java 物件 → 變成位元組 → 存到檔案
		try {
			ObjectOutputStream oout = new ObjectOutputStream(
					new FileOutputStream("dir1/lab571.obj"));
//			把資料寫到lab571.obj這個檔案裡
			
			
//			寫成檔案(序列化)
			oout.writeObject(obj);
//			把obj(也就是 lab573 物件) 轉成一連串位元組，寫進 lab571.obj 檔案
			
			
			oout.flush();
			oout.close();
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("-------");
		
//		解序列化
//		解序列化時，建構式不會被呼叫
//		直接從位元組重建物件，不再重新 new 物件
		try {
			ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir1/lab571.obj"));
//					之後讀檔案的位元組回來
			
//			讀回物件(解序列化)
			Object obj2 = oin.readObject();
//			把剛剛寫進去的東西，打開還原成真正的Java物件
		
			
			oin.close();
			System.out.println("OK2");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}

//	→ 因為 lab573 繼承了 lab571，而 lab571 implements Serializable，
//	→ 所以整個物件樹（lab571 → lab572 → lab573）都會被正確序列化。
//	每個class 加上implements Serializable後結果不同
class lab571 implements Serializable{
	lab571(){System.out.println("lab571");}
}
class lab572 extends lab571{
	lab572(){System.out.println("lab572");}
}
class lab573 extends lab572{
	lab573(){System.out.println("lab573");}
}

//	若某一層沒有implements Serializable，那解序列化時該層會重新執行建構式
//	因為 JVM 不知道怎麼從位元組還原它，就當成全新建構的
//	若每層都有(從父類別就有其他子類別會繼承)，則不會跑任何建構式，JVM 直接從位元組還原物件

//	實作 Serializable 的物件，JVM 可以用檔案的位元組重建完整狀態
//	沒實作的物件，JVM 不知道怎麼還原狀態（位元組不含它的狀態），所以會走建構式

//	序列化成功不會走建構式；沒有Serializable(序列化)才會走建構式印出字來

//	序列化 = 記錄屬性值，不記錄建構式
//	解序列化 = 還原屬性值，不呼叫建構式











