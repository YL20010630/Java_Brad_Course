package tw.apis;


import java.util.List;

/*
	DAO 介面（規範功能）
	Interface（規格），只定義不實做
 */

public interface MemberDAO {
	void addMember(Member member);
	void updateMember(Member member);
	void delMember(int id);
	Member findById(int id);
	List<Member> findAll();
}