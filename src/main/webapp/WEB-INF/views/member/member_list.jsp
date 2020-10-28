<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"  %>
<%
	request.setCharacterEncoding("UTF-8");

	List list = (List)request.getAttribute("list");
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
		<% for(int i = 0; i < list.size(); i++) { %>	
		<tr>
			<td><a href="MemberInfo.me?userId=<%= list.get(i) %>"><%= list.get(i) %></a></td>
			<td><a href="MemberDelete.me?userId=<%=list.get(i)%>">삭제</a></td>
		</tr>
		<%} %>
	</table>
</div>
</body>
</html>