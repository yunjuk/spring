package com.kh.quiz;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //데이터베이스랑 통신을 하니까 리파지토리로 애너테이션 해줌. 
public class QuizDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	//실행될 수 있는 메서드 하나를 만듦. 
	public QuizDO submitAnswer (QuizDO answer) {
		return sqlSession.selectOne("quizMapper.submitAnswer", answer);
		 
	}
}
