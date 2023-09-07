package com.company.hello.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	

	
	
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/signUp") //url경로 연결
	public String signUp() {
		return "sign_up";
		
		
	}
	@RequestMapping("/signIn")
	public String signIn() {
		return "sign_in";
	}
	
		
	//클라이언트에서 헬로 사인컨펌 요청이 서버에 전송되면, 호출되는 메서드다.
	//리퀘스트 파람 애너테이션으로 받을 수 있다. 
	
	@RequestMapping("/signUpConfirm") 
	public String signUpConfirm(MemberVO memberVO) {
		System.out.println("[MemberController] signUpConfirm()");
		
		System.out.println("m_id:" + memberVO.getM_id());
		System.out.println("m_pw:" + memberVO.getM_pw());
//		System.out.println("m_pw_type:" + ((Object)getM_pw).getClass().getName());
		System.out.println("m_mail:" + memberVO.getM_mail());
		System.out.println("m_phone:" + memberVO.getM_phone());
		
		memberService.signUpConfirm(memberVO);
		return "sign_up_ok";
		
	}
	//사인 인풋 코드 
	@RequestMapping("/signInConfirm")
	public String signInConfirm(MemberVO memberVO) {
		System.out.println("[MemberController] signConfirm()");
		
		
		//서비스 호출
		MemberVO signInedMember = memberService.signInConfirm(memberVO);
		
		if (signInedMember != null) // 로그인 성공
			return "sign_up_ok"; //나는 이부분 in으로 안하고 up으로 함 
		else     //로그인 실패
			return "sign_in_ng";
		
		
		// return null; 이 부분은 필요없어져서 주석처리 
		
	}
			
		
	}
	

