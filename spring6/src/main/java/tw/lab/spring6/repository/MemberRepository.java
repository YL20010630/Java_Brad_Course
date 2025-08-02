package tw.lab.spring6.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.lab.spring6.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	/* 命名原則
	 * 	[動詞]By[欄位][中間詞][欄位][條件][中間詞][欄位][條件]...
	 * [動詞]: findBy, getBy, queryBy, readBy
	 * [中間詞] And, Or, Between, Like, NotLike, In, IsNull
	 *  LessThan, GreaterThan
	*/
	Optional<Member> findByEmail(String email);
	//List<Member> findByAge(Long);
	// Integer countByEmail(String email);
	//deleteByOrderDateAtBefore(Date/LocaleDate);
	//findByNameAndAge(String name, String age);
	// findByNameLike(String key);
	// findByNameLikeOrderByNameAscEmailDesc(String key);
	// findByNameIsNull()
}