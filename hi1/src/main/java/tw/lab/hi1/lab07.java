package tw.lab.hi1;

import tw.lab.apis.BCrypt;
import tw.lab.dao.MemberDao;
import tw.lab.entity.Member;
import tw.lab.entity.MemberInfo;

public class lab07 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
//		Member member = new Member();
//		member.setAccount("ok2");
//		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
//		member.setName("OK2");
//		
//		MemberInfo info = new MemberInfo();
//		info.setBirthday("1999-01-02");
//		info.setGender("male");
//		
//		member.setMemberinfo(info);
//		
//		dao.save(member);
		
//		-----------------------
//		Member member = dao.getById(1);
//		MemberInfo info = new MemberInfo();
//		info.setBirthday("2000-10-10");
//		info.setGender("Female");
//		
//		member.setMemberinfo(info);
//		dao.update(member);
		
//		-------------------------
		Member member = dao.getById(17);
		dao.delete(member);
		
		dao.update(member);
		
//		Member member = dao.getById(16);
//		MemberInfo info =  member.getMemberinfo();
//		System.out.println(info.getBirthday());
		
		
		
		
		
	}

}