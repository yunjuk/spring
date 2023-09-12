package DAO;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import VO.Member;

public class MemberDAO<SqlSessionTemplate> {

	@Autowired
	private SqlSessionTemplate sqlSession;
	public Member loginMember(Member answer) {
		return sqlSession.selectOne("memberMapper.loginMember", answer);
	}	
	
	
}
