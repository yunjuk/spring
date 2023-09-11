package com.ncs.test.member.model.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ncs.test.member.model.vo.Member;


public class MemberDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	public Member loginMember(Member answer) {
		return sqlSession.selectOne("memberMapper.loginMember", answer);
	}	

}
