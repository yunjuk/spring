package com.kh.quiz;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuizController {
	@Autowired
	private QuizService quizService;

	@RequestMapping("quizSubmitted")
	//주소 매핑, 아까 만든 인덱스.xml에 있는 주소로, 여기로 경로를 지정함
	public String answerSubmit(QuizDO answeredQuestion, Model model, HttpServletRequest request) {
		//여기다가 답변을 적어다가 보내면 답변을 저장할 DO객체 만들어야 함 
		
		//인덱스 값을 퀴즈디오 앤셜퀘스쳔에 저장할 거임. 
		
		QuizDO quizDO = quizService.submitAnswer(answeredQuestion);
		HttpSession session = request.getSession();
		if(quizDO == null) {
			return "error";
		}
		else {
			return "index";
		}
	}
	
	
}
