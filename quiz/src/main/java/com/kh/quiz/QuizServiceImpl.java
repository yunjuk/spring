package com.kh.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizDAO quizDAO;
	
	@Override
	public QuizDO submitAnswer(QuizDO quizDO) {
		return quizDAO.submitAnswer(quizDO);
	}
	
}
