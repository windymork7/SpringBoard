<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
	<title>MVC 게시판</title>
</head>

<body>


<div align="center">
	<h1>JDBC버전 게시판</h1>
	<hr>
	<!-- 게시판 리스트 -->
	<table width=50% border="0" cellpadding="0" cellspacing="0">
		<tr align="center" valign="middle">
			<td colspan="4">MVC 게시판</td>
			<td align=right>
				<font size=2>글 개수 : ${listcount }</font>
			</td>
		</tr>
		
		<tr align="center" valign="middle" bordercolor="#333333">
			<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
				<div align="center">번호</div>
			</td>
			<td style="font-family:Tahoma;font-size:8pt;" width="50%">
				<div align="center">제목</div>
			</td>
			<td style="font-family:Tahoma;font-size:8pt;" width="14%">
				<div align="center">작성자</div>
			</td>
			<td style="font-family:Tahoma;font-size:8pt;" width="17%">
				<div align="center">날짜</div>
			</td>
			<td style="font-family:Tahoma;font-size:8pt;" width="11%">
				<div align="center">조회수</div>
			</td>
		</tr>
		
		<c:forEach var="board" items="${boardlist }">
		<tr align="center" valign="middle" bordercolor="#333333"
			onmouseover="this.style.backgroundColor='F8F8F8'"
			onmouseout="this.style.backgroundColor=''">
			<td height="23" style="font-family:Tahoma;font-size:10pt;">
				${board.BOARD_NUM }
			</td>
			
			<td style="font-family:Tahoma;font-size:10pt;">
				<div align="left">
				
				<c:choose>
					<c:when test="${board.BOARD_RE_LEV != 0 }">
						<c:forEach begin="0" end="${board.BOARD_RE_LEV*2 }">
							&nbsp;
						</c:forEach>
						▶
					</c:when>
					<c:otherwise>
						▶
	   				</c:otherwise>
				</c:choose>
				<a href="./BoardDetailAction.bo?num=${board.BOARD_NUM }">
					${board.BOARD_SUBJECT }
				</a>
				</div>
			</td>
			
			<td style="font-family:Tahoma;font-size:10pt;">
				<div align="center">${board.BOARD_NAME }</div>
			</td>
			<td style="font-family:Tahoma;font-size:10pt;">
				<div align="center">${board.BOARD_DATE }</div>
			</td>	
			<td style="font-family:Tahoma;font-size:10pt;">
				<div align="center">${board.BOARD_READCOUNT }</div>
			</td>
		</tr>
		</c:forEach>
		<tr align=center height=20>
			<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
				<c:choose>
					<c:when test="${page <= 1 }">
						[이전]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="./BoardList.bo?page=${page-1 }">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="str" begin="${startpage }" end="${endpage }" step="1">
					<c:choose>
						<c:when test="${str == page }">
							[${str }]
						</c:when>
						<c:otherwise>
							<a href="./BoardList.bo?page=${str }">[${str }]</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>	
				
				<c:choose>
					<c:when test="${page >= maxpage}">
					[다음]
					</c:when>
					<c:otherwise>
					<a href="./BoardList.bo?page=${page+1 }">[다음]</a>
					</c:otherwise>
				</c:choose>		
			</td>
		</tr>
		<tr align="right">
			<td colspan="5">
		   		<a href="./BoardWrite.bo">[글쓰기]</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>