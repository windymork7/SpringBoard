<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String userId = (String)session.getAttribute("userId");
	System.out.println((String)session.getAttribute("userId"));
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
		
	<% if(userId.equals("ADMIN")) {%>
		<a href="Member_list.me">관리자만 보이는 링크</a>
	<%} %>
</div>
</body>
</html>