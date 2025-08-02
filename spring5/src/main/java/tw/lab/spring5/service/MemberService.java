package tw.lab.spring5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import tw.lab.spring5.entity.Member;
import tw.lab.spring5.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private EntityManager manager;
	
	public void query1() {
		String jpql = "SELECT m FROM Member m WHERE m.account = :account";
		List<Member> members = manager.createQuery(jpql, Member.class)
				.setParameter("account", "Eli")
				.getResultList();
		for (Member member : members) {
			System.out.println(member.getAccount());
		}
	}
	public void query2() {
		 Member member = repository.findByAccountV2("Eli").orElse(null);
		 if (member != null) {
			 System.out.println(member.getAccount());
		 }
	}
	public void query3() {
		List<Member> members = repository.m1("Eli");
		for (Member member : members) {
			System.out.println(member.getAccount());
		}
	}
	
}