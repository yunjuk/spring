package com.company.cookie.member;

import java.io.OutputStream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class MemberController {

	@GetMapping({ "", "/" })
	public String home() {
		System.out.println("[MemberController] home()");

		String nextPage = "member/home";

		return nextPage;
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("[Membercontroller] loginForm()");
		String nextPage = "/member/login_form";
		return nextPage;

	}

	@PostMapping("/loginConfirm")
	public String loginConfirm(@RequestParam("m_id") String m_id, @RequestParam("m_pw") String m_pw,
			HttpServletResponse response) {
 // 매개변수 3개를 받음 
		System.out.println("[MemberController] loginConfirm()");
//쿠키 저장할 그릇. 사용자의 컴퓨터에 저장이 되는 것은 쿠키. 
		String nextPage = "member/login_ok";
		//리턴을 해서 돌아갈 졔스피 페이지를 써줌. 
		
		if (m_id.equals("user") && m_pw.equals("1234")) {
			Cookie cookie = new Cookie("loginMember", m_id);
			cookie.setMaxAge(60 * 30);
			response.addCookie(cookie);
		} else {
			nextPage = "member/login_ng";
		}
		return nextPage;

	}
	
	@GetMapping("/logoutForm")
	public String logoutForm(@CookieValue(value = "loginMember", required = false)
	String loginMember, HttpServletResponse response) {
		System.out.println("[MemberController] loginConfirm()");
		
		String nextPage = "redirect:/member/";
		
		Cookie cookie = new Cookie("loginMember", loginMember);
		cookie.setMaxAge(0);
		
		response.addCookie(cookie);
		
		return nextPage;
	}	
}
