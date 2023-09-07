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
		<form action="quizSubmitted" method="post">
		<label> 1 + 1 = </label> <input type="text" name="answerOne">
		<button>제출</button>
		</form>
	</c:if>
	
	<c:if test="${!empty answer}">
		<h1>정답입니다.</h1>
	</c:if>
</body>
</html>