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
<title>member_list.jsp</title>
<style type="text/css">
	table, tr, td
	{
		border: 1px solid;
	}
</style>
</head>
<body>
<div align="center">
	<h1>회원목록</h1>
	<hr>
	
	<table>
		<c:forEach var="userId" items="${list }">
		<tr>
			<td><a href="MemberInfo.me?userId=${userId }">${userId }</a></td>
			<td><a href="MemberDelete.me?userId=${userId }">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>