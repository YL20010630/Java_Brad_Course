package tw.lab.hi1;

import java.io.FileInputStream;

import tw.lab.dao.MemberDao;
import tw.lab.entity.Member;
import tw.lab.entity.MemberInfo;

public class lab08 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member member = dao.getById(2);
		
		if(member != null) {
			try {
				FileInputStream fin = new FileInputStream("C:\\Users\\皮\\eclipse-workspace\\hi1\\dir1\\ball.png");
				byte[] ball = fin.readAllBytes();
				member.setMyicon(ball);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			MemberInfo info = new MemberInfo();
			info.setBirthday("2000-01-02");
			info.setGender("female");
			member.setMemberinfo(info);
			
			dao.update(member);
			
		}else {
			System.out.println("Member 2 NOT EXIST!");
		}
		
	}
}