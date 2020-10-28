<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고뇌의 수정</title>
</head>
<style>
   th	
   {
      background-color: #A9BCF5;
   }
   

   table, th, tr, td
   {	
      border: 1px solid;
   }
   
</style>
<!-- <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="js/joinvali.js"></script>
<script src="js/mapApi.js"></script> -->
<body>
<form name="join" action="updateProcess.jsp" method="post">
   <div align="center">
      <table>
         <tr>
            <th colspan="2">회원 기본 정보</th>
         </tr>
         <tr>
            <td align="center">아이디 : </td>
            <td>
               <input type="text" id="userId" name="userId" value="" readonly="readonly">4~12자의 영문 대소문자와 숫자로만 입력
            </td>
         </tr>
         <tr>
            <td align="center">비밀번호 : </td>
            <td>
               <input type="password" id=userPw name="userPw" value="" readonly="readonly">4~12자의 영문 대소문자와 숫자로만 입력
            </td>
         </tr>
         <tr>
            <td align="center">비밀번호 확인 : </td>
            <td>
               <input type="password" id=userPwConfirm name="userPwConfirm" value="" readonly="readonly">
            </td>
         </tr>
         <tr>
            <td align="center">메일주소 : </td>
            <td>
               <input type="email" id="userMail" name="userMail" value="" readonly="readonly">예) id@domain.com
            </td>
         </tr>
         <tr>
            <td align="center">이름 : </td>
            <td>
               <input type="text" id="userName" name="userName" value="" readonly="readonly">
            </td>
         </tr>
         <tr>
            <th colspan="2">개인 신상 정보</th>
         </tr>
         <tr>
         	<td align="center">우편번호 : </td>
         	<td>
         		<input type="text" id="Postal code" name="PostalCode" value="" readonly="readonly">
         		<button type="button" onclick="sample4_execDaumPostcode()">&nbsp;우편번호검색</button><br>
         		<input type="text" id="Road address" name="RoadAddress" value="" readonly="readonly">&nbsp;
         		<input type="text" id="branch address" name="branchAddress" value="" readonly="readonly"><br>
         		<input type="text" id="sub address" name="subAddress" value="" readonly="readonly">
         	</td>
         </tr>
         <tr>
            <td align="center">주민등록번호 : </td>
            <td>
               <input type="text" id="jubun1" name="jubun1" style="width: 72px;" maxlength="6" value="" readonly="readonly"> -
               <input type="password" id="jubun2" name="jubun2" style="width: 72px;" maxlength="7" value="" readonly="readonly"> 예) 123456-1234567
            </td>
         </tr>
         <tr>
            <td align="center">생일 : </td>
            <td>
               <input type="text" id="year" name="year1" style="width: 70px;" readonly="readonly">년
               <input type="text" id="month" name="month1" style="width: 20px;" readonly="readonly">월
               <input type="text" id="date" name="date1" style="width: 20px;" readonly="readonly">일
            </td>
         </tr>
         <tr>
            <td align="center">관심분야 : </td>
            <td>
            	<input type="text" name="hobby" value="" readonly="readonly">
            </td>
         </tr>
         <tr>
            <td align="center">자기소개 : </td>
            <td>
               <textarea id="intro" name="intro" style="width: 450px; height: 200px; resize: none; readonly="readonly"></textarea>
            </td>
         </tr>
         <tr>
            <td colspan="2" align="center">
               <!-- <button type="button" onclick="vali()">수정하기</button>
               <input type="reset" value="다시 입력"> -->
               <button type="button" onclick="history.back()">뒤로가기</button>
            </td>
         </tr>
      </table>
     
   </div>
</form>
</body>
<!-- <script>
	var userIdObj = document.getElementById("userId");	// 아이디 
	var userPwObj = document.getElementById("userPw");	// 패스워드 
	var userPwConfirmObj = document.getElementById("userPwConfirm");	// 패스워드 확인 
	var userEmailObj = document.getElementById("userMail");	// 이메일 접근
	var userNameObj = document.getElementById("userName");	// 이름 접근
	var roadAddressObj = document.getElementById("Road address");	// 도로명 주소
	var subAddressObj = document.getElementById("sub address");	// 상세주소 
	var jubun1Obj = document.getElementById("jubun1");	// 주민번호1
	var jubun2Obj = document.getElementById("jubun2");	// 주민번호2
	var yearObj = document.getElementById("year");	// 년도
	var monthObj = document.getElementById("month");	// 월
	var dateObj = document.getElementById("date");	// 일
	var hobbyObj = document.getElementsByName("hobby");	// 취미
	var introObj = document.getElementById("intro");	// 자기소개
	var re = /^[a-zA-Z0-9]{4,12}$/;	// 아이디 패스워드 정규식
	var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;	// 이메일 정규식
	var arrjubun1 = new Array();	// 주민번호1 담은 배열
	var arrjubun2 = new Array();	// 주민번호2 담은 배열
	var result = 0;	// 주민번호 유효성 검사 확인
</script> -->
</html>