<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 화면</h2>
	<c:if test="${empty loginMember}">
		<form action="login" method="post">
			<label> ID : </label> <input type="text" name="memberId"> <br>
			<label>PWD : </label> <input type="password" name="memberPwd">
			<br>
			<button>로그인</button>
		</form>
	</c:if>
	<c:if test="${!empty loginMember}">
		<h3>${loginMember.memberName}님 환영합니다.</h3>
	</c:if>
</body>
</html>