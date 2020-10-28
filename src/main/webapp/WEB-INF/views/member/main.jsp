<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<div align="center">
	<h1>메인 페이지</h1>
	<hr>
	<h3>${userId }님 로그인 하셨습니다.</h3>
	
	<a href="BoardList.bo">게시판으로 가기</a><br><br>
		
	<c:if test="${userId == 'ADMIN'}">
		<a href="Member_list.me">관리자만 보이는 링크</a>
	</c:if>
</div>
</body>
</html>