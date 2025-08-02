package tw.lab.spring2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import tw.lab.spring2.entity.Member;
import tw.lab.spring2.repository.MemberRepository;
import tw.lab.spring2.utils.BCrypt;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;
	
	public MemberService() {System.out.println("MemberService()");}
	
	public boolean checkAccount(String account) {
		return memberRepository.existsByAccount(account);
	}
	
	public String register(Member member) {
		if (memberRepository.existsByAccount(member.getAccount())) {
			return "Account 已使用";
		}
		member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		memberRepository.save(member);
		return "註冊成功";
	}
	
	public boolean login(String account, String passwd) {
		Member member = memberRepository.findByAccount(account).orElse(null);
		if (member != null && BCrypt.checkpw(passwd, member.getPasswd())) {
			return true;
		}
		return false;
	}
	
	public boolean loginV2(String account, String passwd) {
		Member member = new Member();
		member.setAccount(account);
		
		Example<Member> ex = Example.of(member);
		if (memberRepository.exists(ex)) {
			List<Member> members = memberRepository.findAll(ex);
			if (BCrypt.checkpw(passwd, members.get(0).getPasswd())) {
				return true;
			}
		}
		return false;
	}
	
//	public Member loginV3(String account, String passwd) {
//		Member member = memberRepository.findByAccount(account).orElse(null);
//		if (member != null && BCrypt.checkpw(passwd, member.getPasswd())) {
//			return member;
//		}
//		return null;		
//	}
	public Member loginV3(String account, String passwd) {
        System.out.println("查詢帳號: " + account);
        Member member = memberRepository.findByAccount(account).orElse(null);
        if (member != null) {
            System.out.println("查詢到會員，準備驗證密碼");
            if (BCrypt.checkpw(passwd, member.getPasswd())) {
                System.out.println("密碼驗證通過");
                return member;
            } else {
                System.out.println("密碼錯誤");
            }
        } else {
            System.out.println("查無此帳號");
        }
        return null;
    }
	
	
	
}