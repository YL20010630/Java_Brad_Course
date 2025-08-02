package tw.YL;

import java.sql.Connection;
import java.util.List;

import tw.apis.labUtils;
import tw.apis.Member;
import tw.apis.MemberDAO;
import tw.apis.MemberDAOImpl;

/*
	透過 MemberDAO（資料存取層）來操作資料庫中的 member 表格
	查詢、修改、刪除會員資料
 */

public class lab77 {

	public static void main(String[] args) {
		try(Connection conn = labUtils.getConnection()) {
			MemberDAO dao = new MemberDAOImpl(conn);
			
//			Member member = new Member();
//			member.setName("伊莎貝拉");
//			member.setAccount("Esabera");
//			member.setPasswd("1234567");
//			dao.addMember(member);
//			
//			System.out.println("OK");
			
			Member member = dao.findById(3);
			if (member != null) {
				member.setName("I am No.3");
				dao.updateMember(member);
			}
			
//			System.out.println(member.getId());
//			System.out.println(member.getName());
//			System.out.println(member.getAccount());
//			System.out.println(member.getPasswd());
			
			dao.delMember(4);
			System.out.println("----");
			List<Member> list = dao.findAll();
			for (Member m: list) {
				System.out.println(m.getName());
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}