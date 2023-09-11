package com.ncs.test.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDAO;
import com.ncs.test.member.model.vo.Member;


public interface MemberService {
	

	public abstract Member loginMember(Member member);
	
	
}
