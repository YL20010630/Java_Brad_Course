package tw.YL;

import tw.apis.Member;

import java.util.HashSet;

public class lab36 {

	public static void main(String[] args) {
//		Member m1 = new Member(1, "Andy");
//		Member m2 = new Member(2, "Betty");
//		Member m3 = new Member(3, "Cindy");
//		Member m4 = new Member(4, "David");
		
		Member m1 = new Member(1, "Andy", "", "");
		Member m2 = new Member(2, "Betty", "", "");
		Member m3 = new Member(2, "Cindy", "", "");
		Member m4 = new Member(1, "David", "", "");
		
//		泛型：在指定資料結構裡面只能放什麼元素
//		Hash 雜湊 
		HashSet<Member> members = new HashSet<>();
		
		members.add(m1);members.add(m2);
		members.add(m3);members.add(m1);
		
		members.add(m1);
		members.add(m2);
		members.add(m3);
		members.add(m4);

		System.out.println(members.size());
		System.out.println(members);
	}
	
	

}
