package tw.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


import tw.apis.Bike;


public class test_09_serialization {
	
	/*
		序列化/解序列化
		ObjectOutputStream	物件 → 位元組 (序列化)
		ObjectInputStream	位元組 → 物件 (解序列化)
		
	 */

	public static void main(String[] args) {
		Student s1 = new Student("Cecillia", 60, 70, 80);
		System.out.println(s1);
		System.out.println(s1.name);
		System.out.println(s1.sum());
		System.out.println(s1.getBike().upSpeed().upSpeed());
		
//		序列化
		try {
			FileOutputStream fout = new FileOutputStream("dir2/test_09");
			ObjectOutputStream oot = new ObjectOutputStream(fout);
			oot.writeObject(s1);
			oot.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		解序列化
		try {
			FileInputStream fin = new FileInputStream("dir2/test_09");
			ObjectInputStream oin = new ObjectInputStream(fin);
			Object obj = oin.readObject();
			
			Student s2 = (Student)obj;		// 記得轉型
			oin.close();
			
			System.out.println(s2);
			System.out.println(s2.name);
			System.out.println(s2.sum());
			System.out.println(s2.getBike().upSpeed().upSpeed());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Student implements Serializable {
//	宣告需要的屬性
	String name;
	int ch; int eng; int math;
//	Bike bike = new Bike();		// 錯誤
	Bike bike;
	
//	該類別建構式
	public Student(String name, int ch, int eng, int math) {
		this.name = name;
		this.ch = ch; this.eng = eng; this.math = math;
//		Bike bike = new Bike();		// 錯誤
		bike = new Bike();
		System.out.println("序列化成功不會走建構式");		// new Student(...)時會印出
	}
	
//	功能
	public int sum() {
		return ch+eng+math;
	}
	
	public Bike getBike() {
//		return bike();		// 錯誤，是屬性(物件)，不是方法
		return bike;
	}
	
}
