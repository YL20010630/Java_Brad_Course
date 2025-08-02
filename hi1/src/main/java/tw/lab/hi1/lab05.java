package tw.lab.hi1;

import java.util.List;

import tw.lab.apis.BCrypt;
import tw.lab.dao.MemberDao;
import tw.lab.entity.Member;

public class lab05 {

	public static void main(String[] args) {
		Member member = new Member();
//		member.setAccount("Flien");
//		member.setPasswd(BCrypt.hashpw("12345", BCrypt.gensalt()));
//		member.setName("芙蓮");
		
		MemberDao dao = new MemberDao();
		
//		dao.save(member);
//		dao.update(member);
		
		Member m5 = dao.getById(5);
		System.out.println(m5.getId() + ":" + m5.getAccount() + ":" + m5.getName());
		m5.setAccount("Karol");
		dao.update(m5);
		
//		-----------------------------
		List<Member> members = dao.getAll();
		for(Member mb : members) {
			System.out.println(mb.getAccount());
		}
		
//		-----------------------------
		System.out.println("-----");
		List<Member> ms = dao.getByKey("a");
		for (Member mb : ms) {
			System.out.println(mb.getAccount() + ":" + mb.getName());
		}
		
	}

}
