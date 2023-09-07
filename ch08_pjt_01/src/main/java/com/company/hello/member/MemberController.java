package com.company.hello.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
	
	
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
	public String signUpConfirm(@RequestParam String m_id,
								@RequestParam int m_pw,
								@RequestParam String m_mail,
								@RequestParam String m_phone) {
		System.out.println("[MemberController] signUpConfirm()");
		
		System.out.println("m_id:" + m_id);
		System.out.println("m_pw:" + m_pw);
		System.out.println("m_pw_type:" + ((Object)m_pw).getClass().getName());
		System.out.println("m_mail:" + m_mail);
		System.out.println("m_phone:" + m_phone);
		
		return null;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
