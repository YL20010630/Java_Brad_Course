package tw.YL;

import tw.apis.Ispan01;
import tw.apis.Ispan02;


public class lab20 {

	public static void main(String[] args) {
		Ispan01 i1 = new Ispan01();   // 所有class都有建構式
//		這裡 new Ispan01() 會呼叫 Ispan01 這個類別的建構式
		i1.m1();
		Ispan02 i2 = new Ispan02();
		i2.m1();
		

	}

}
