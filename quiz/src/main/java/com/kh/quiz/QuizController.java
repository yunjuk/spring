package com.kh.quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
	@Autowired // 우리가 직접 생산하는 게 아니라 스프링한테 맡김. 
	private QuizService quizService;
	
	@RequestMapping("/")
	public String toMainPage() {
		return "index";
	}
	
	
	@RequestMapping("quizSubmitted")
	public String answerSubmit(QuizDO answer, Model model,
			HttpServletRequest request) {
		QuizDO quizDO = quizService.submitAnswer(answer);
		HttpSession session = request.getSession();
		if(quizDO == null) {
			model.addAttribute("msg","Wrong answer");
			return "error";
		}else {
			session.setAttribute("answer", quizDO);
			return "index";
		}
	}
}
