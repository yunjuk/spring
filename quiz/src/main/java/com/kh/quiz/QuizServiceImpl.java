package com.kh.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //이렇게 하면 빈으로 등록이 됨.
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizDAO quizDAO;
	
	@Override
	public QuizDO submitAnswer(QuizDO answer) {
		return quizDAO.submitAnswer(answer);
	}
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    