package tw.lab.spring5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.lab.spring5.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
//	查詢 account 完全符合，自動推導的 SQL，簡潔但不能加條件
	Member findByAccount(String account);
	
//	查詢 account 完全符合，自訂 JPQL，可調整結構
	@Query("SELECT m FROM Member m WHERE m.account = :account")
	Optional<Member> findByAccountV2(@Param("account") String account);
	
//	模糊搜尋帳號、排序
	@Query("SELECT m FROM Member m WHERE m.account LIKE %:key% ORDER BY m.account")
	List<Member> m1(@Param("key") String keyword);
}