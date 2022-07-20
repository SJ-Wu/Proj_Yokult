package web.member.service;

import java.util.List;

import web.member.vo.Member;

public interface MemberService {
	Member getOne(String account);
	
	List<Member> getAll();
	
	Integer register(Member member);

	Member login(Member member);

	Integer modify(Member member);

	Integer remove(Member member);
}
