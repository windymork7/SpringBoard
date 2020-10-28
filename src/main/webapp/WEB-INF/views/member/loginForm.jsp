<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
<style type="text/css">
	table, tr, td
	{
		border: 1px solid;	
	}
</style>
</head>
<body>
<form name="loginForm" action="loginProcess.me" method="post">
	<div align="center">
		<h1>로그인</h1>
		<hr>
		
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="userId" name="userId">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" id="userPw" name="userPw">
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<button type="button" onclick="vali()">로그인</button>
					<button type="button" onclick="location.href='MemberJoin.me'">회원가입</button>
				</td>
			</tr>
		</table>
	</div>
</form>
</body>
<script type="text/javascript">
	
	function vali()
	{
		userIdObj = document.getElementById("userId");
		userPwObj = document.getElementById("userPw");
		
		
		if (userIdObj.value == "") 
		{
			alert("아이디를 입력해 주세요!");
			userIdObj.focus();
			return false;
		}
		
		if (userPwObj.value == "") 
		{
			alert("비밀번호를 입력해 주세요!");
			userPwObj.focus();
			return false;
		}
		
		document.loginForm.submit();
	}
	
	
</script>
</html>