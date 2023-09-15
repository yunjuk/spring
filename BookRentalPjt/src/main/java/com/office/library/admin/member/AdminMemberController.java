package com.office.library.admin.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	
	
	
	
	@Autowired
	AdminMemberService adminMemberService;
	
	
	@RequestMapping(value="/createAccountForm",
			method=RequestMethod.GET)
	public String createAccountForm() {
		System.out.println("[AdminMemberController] createAccountForm()");
		String nextPage = "admin/member/create_account_form";
		
		return nextPage;
	}
	
	@PostMapping("/createAccountConfirm")
	public String createAccountConfirm(AdminMemberVO adminMemberVO) {
		System.out.println("[AdminMemberController]createAccountConfirm()");
		int result = adminMemberService.createAccountConfirm(adminMemberVO);
		
		String nextPage = "admin/member/create_account_ok";
		
		if (result <= 0 ) {
			nextPage = "admin/member/create_account_ng";
			
			
		}
		return nextPage;
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("[AdminMemberController]loginForm()");
		String nextPage = "admin/member/login_form";
		return nextPage;
	}
	
	
	@PostMapping("/loginConfirm")
	public String loginConfirm(AdminMemberVO adminMemberVO,
		 HttpSession session) {
		System.out.println("[AdminMemberController] loginConfirm()");
		
		String nextPage = "admin/member/login_ok";
		
		AdminMemberVO loginedAdminMemberVO = 
				adminMemberService.loginConfirm(adminMemberVO);
		if(loginedAdminMemberVO == null) {
			nextPage = "admin/member/login_ng";
		}else {
			session.setAttribute("loginedAdminMemberVO", loginedAdminMemberVO);
			session.setMaxInactiveInterval(60*30);
			//60초 곱하기 30해서 30분이란 뜻, 세션의 유효기간을 말함. 브라우저가
			//추가적인 요청을 30분동안 하지 않게 되면은 새로운 세션을 요구하게 되고 
			//다시 로그인하라고 뜨게 하는 기능. 
		}
		return nextPage;
		
	}
	@GetMapping("/logoutConfirm")
	public String logoutConfirm(HttpSession session) {
		System.out.println("[AdminMemberController] logoutConfirm()");
		String nextPage = "redirect:/admin";
				
		session.invalidate();
		
		return nextPage;
	}
	
	
	@GetMapping("/listupAdmin")
	public ModelAndView listupAdmin(Model model) {
		System.out.println("[AdminMemberController] modifyAccountConfirm()");
		
		String nextPage = "admin/member/listup_admins";
		
		List<AdminMemberVO> adminMemberVOs = adminMemberService.listupAdmin();
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("adminMemberVOs", adminMemberVOs);
		modelAndView.setViewName(nextPage);
		
//		model.addAttribute("adminMemberVOs", adminMemberVOs);
		
		return modelAndView;
		
	}
	
	@GetMapping("/setAdminApproval")
	public String setAdminApproval(@RequestParam("a_m_no") int a_m_no) {
		System.out.println("[AdminMemberController]setAdminApproval()");
		
		String nextPage = "redirect:/admin/member/listupAdmin";
	
		adminMemberService.setAdminApproval(a_m_no);
		return nextPage;
	}
	
	
	
	
	
}
