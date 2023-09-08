<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>퀴즈 페이지입니다</title>
</head>
<body>
	<c:if test="${empty answer}">
	
		<form action="/quizSubmitted" method="post">
		<label>1. 1 + 1 = </label> <input type="hidden" name="question1" value="1">
		<input type="text" name="answer1" />
		
			<label>2. 2 + 1 = </label> <input type="hidden" name="question2" value="2">
		<input type="text" name="answer2" />
		
			<label>3. 3 + 1 = </label> <input type="hidden" name="question3" value="3">
		<input type="text" name="answer3" />
		
			<label>4. 4 + 1 = </label> <input type="hidden" name="question4" value="4">
		<input type="text" name="answer4" />
		
			<label>5. 5 + 1 = </label> <input type="hidden" name="question5" value="5">
		<input type="text" name="answer5" />
		
			<label>6. 6 + 1 = </label> <input type="hidden" name="question6" value="6">
		<input type="text" name="answer6" />
		
			<label>7. 7 + 1 = </label> <input type="hidden" name="question7" value="7">
		<input type="text" name="answer7" />
		
			<label>8. 8 + 1 = </label> <input type="hidden" name="question8" value="8">
		<input type="text" name="answer8" />
		
			<label>9. 9 + 1 = </label> <input type="hidden" name="question9" value="9">
		<input type="text" name="answer9" />
		
			<label>10. 10 + 1 = </label> <input type="hidden" name="question10" value="10">
		<input type="text" name="answer10" />
		<button>제출</button>
		</form>
	</c:if>
	
	<c:if test="${!empty answer}">
		<h1>정답입니다.</h1>
	</c:if>
</body>
</html>