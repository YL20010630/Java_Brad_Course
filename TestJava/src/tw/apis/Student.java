package tw.apis;

import java.io.Serializable;

//	Serializable 是 一個「標記介面」，
//	代表這個類別的物件可以被序列化，
//	也就是把它轉成一堆位元組儲存起來，日後還能還原

public class Student implements Serializable {
	private String name;
	private int ch, eng, math;
	private Bike bike;
	
	public Student(String name, int ch, int eng, int math) {
		this.name = name;this.ch = ch;
		this.eng = eng;this.math = math;
		bike = new Bike();
	}
	
	public int sum() {
		return ch + eng + math;
	}
	public double avg() {
		return sum()/3.0;
	}
	public Bike getBike() {
		return bike;
	}
	
}
