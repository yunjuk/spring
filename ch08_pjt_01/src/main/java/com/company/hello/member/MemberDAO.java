package com.company.hello.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

	//사인 인 코드 
	public MemberVO selectMember(MemberVO memberVO) {
		System.out.println("[MemberDAO] selectMember()");
		
		MemberVO signInedMember = memberDB.get(memberVO.getM_id());
		                                            //난 이부분 숫자라 이퀄 안쓰고 == 로 씀. 
		if (signInedMember != null && memberVO.getM_pw() == signInedMember.getM_pw())
			return signInedMember;
		else
		
		    return null;

		
	}
	
	
	
	
	//사인 업 코드 
	private Map<String, MemberVO> memberDB = new HashMap<String, MemberVO>();
	
	public void insertMember(MemberVO memberVO) {
		System.out.println("[MemberDAO] insertMember()");
		
		
		System.out.println("m_id:"+memberVO.getM_id());
		System.out.println("m_pw:"+memberVO.getM_pw());
		System.out.println("m_mail:"+memberVO.getM_mail());
		System.out.println("m_phone:"+memberVO.getM_phone());
		
		
		memberDB.put(memberVO.getM_id(), memberVO);
		this.printAllMember();
		//실제 들어가는 값은 멤버브이오 전체가 들어감. 
	}
	
	//정상적으로 값이 잘 들어갔나 확인하는 출력부분
	private void printAllMember() {
		System.out.println("[MemberDAO] printAllMembers()");
		
		Set<String> keys = memberDB.keySet();
		Iterator<String>iterator = keys.iterator();
		
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			MemberVO memberVO = memberDB.get(key);
			
			System.out.println("m_id:"+memberVO.getM_id());
			System.out.println("m_pw:"+memberVO.getM_pw());
			System.out.println("m_mail:"+memberVO.getM_mail());
			System.out.println("m_phone:"+memberVO.getM_phone());
		}
		
		
		
		
		
		
		
		
		
	}
}
