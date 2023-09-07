package com.kh.quiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizDAO quizDao;
	
	@Override
	public abstract QuizDO submitAnswer(QuizDO quizDO);
	 return quizDao.submitAnswer(quizDao)


	
	
}
