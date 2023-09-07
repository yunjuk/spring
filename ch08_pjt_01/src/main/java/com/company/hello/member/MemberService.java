package com.company.hello.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	
	
	
	//사인 업 코드
	@Autowired
	MemberDAO memberDao;
	public int signUpConfirm(MemberVO memberVO) {
		System.out.println("[MemberService] signUpConfirm()");
		
		
		System.out.println("m_id"+memberVO.getM_id());
		System.out.println("m_pw"+memberVO.getM_pw());
		System.out.println("m_mail"+memberVO.getM_mail());
		System.out.println("m_phone"+memberVO.getM_phone());
		
		memberDao.insertMember(memberVO);
		return 0;
	}
	
	//사인 인풋 코드
	public MemberVO signInConfirm(MemberVO memberVO) {
		System.out.println("[MemberService] signInConfirm()");
		//memberVO를 매개 변수로 전달
		MemberVO signInedMember = memberDao.selectMember(memberVO);
		
		return signInedMember;
	}
	
	
	
}
