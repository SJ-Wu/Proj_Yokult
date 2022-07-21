package web.member.dao;

import java.util.List;
import web.member.vo.Member;

public interface MemberDao {
	Integer insert (Member member);
	Member selectByMemberID(String account);
	Member selectByMemberIdAndPassword(Member member);
	List<Member> selectAll();
	Integer update (Member member);
	Integer delete (Member member);
}
