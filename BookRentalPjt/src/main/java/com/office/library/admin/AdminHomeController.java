package com.office.library.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

	
	
	@RequestMapping(value= {"","/"}, method = RequestMethod.GET)
	public String home() {                         //리퀘스트메소드는 임포트함.
		System.out.println("[AdminHomeController] home()");
		
		String nextPage = "admin/home";
		
		return nextPage;
	}
	
}
