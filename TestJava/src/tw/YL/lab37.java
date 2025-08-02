package tw.YL;

import tw.apis.Member;

import java.util.ArrayList;
import java.util.LinkedList;

public class lab37 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("lab1");		// 0
		list.add("lab2");		// 1
		list.add(1, "lab3");	// 1
		list.add(0, "lab4");
//		list.add(7, "lab5");
		list.add(0, "lab6");
		list.add("lab2");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println("------------");
		
		Member m2 = new Member(2, "Betty", "", "");
		Member m3 = new Member(2, "Cindy", "", "");
		Member m4 = new Member(1, "David", "", "");
		Member m1 = new Member(1, "Andy", "", "");
		LinkedList<Member> ms = new LinkedList<>();
		ms.add(m1);
		ms.add(m2);
		ms.add(m3);
		ms.add(m4);
		System.out.println(ms.size());
		System.out.println(ms);

	}

}
