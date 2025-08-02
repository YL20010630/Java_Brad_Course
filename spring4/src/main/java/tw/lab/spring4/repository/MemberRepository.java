package tw.lab.spring4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.lab.spring4.entity.Member;
import java.util.List;


public interface MemberRepository extends JpaRepository<Member, Long>{
	Member findByAccount(String account);
}