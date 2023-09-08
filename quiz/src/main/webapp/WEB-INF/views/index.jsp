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
		<label>1. 1 + 1 = </label> <input type="hidden" name="question" value="1">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
		 	<form action="/quizSubmitted" method="post">
			<label>2. 2 + 1 = </label> <input type="hidden" name="question" value="2">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>3. 3 + 1 = </label> <input type="hidden" name="question" value="3">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>4. 4 + 1 = </label> <input type="hidden" name="question" value="4">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>5. 5 + 1 = </label> <input type="hidden" name="question" value="5">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>6. 6 + 1 = </label> <input type="hidden" name="question" value="6">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>7. 7 + 1 = </label> <input type="hidden" name="question" value="7">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>8. 8 + 1 = </label> <input type="hidden" name="question" value="8">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>9. 9 + 1 = </label> <input type="hidden" name="question" value="9">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
			<form action="/quizSubmitted" method="post">
			<label>10. 10 + 1 = </label> <input type="hidden" name="question" value="10">
		<input type="text" name="answer" />
		<button>제출</button>
		</form>
	</c:if>
	
	<c:if test="${!empty answer}">
		<h1>정답입니다.</h1>
	</c:if>
</body>
</html>