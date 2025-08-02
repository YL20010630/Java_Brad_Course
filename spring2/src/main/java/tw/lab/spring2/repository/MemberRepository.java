package tw.lab.spring2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.lab.spring2.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	boolean existsByAccount(String account);
	
	Optional<Member> findByAccount(String account);
	
}