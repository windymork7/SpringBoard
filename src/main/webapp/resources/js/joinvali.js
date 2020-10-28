	function vali()
	{
		if (idVali() == false) 
			return false;
		if (pwVali() == false) 
			return false;
		if (pwCoVali() ==  false) 
			return false;
		if (emailVali() == false) 
			return false;
		if (nameVali() ==  false) 
			return false;
		if (addressVali() == false) 
			return false;
		if (juVali() == false)
			return false;
		if (hobbyVali() == false)
			return false;
		if (introVali() == false) 
			return false;
		
		
		if (jubun2Obj.value.charAt(0) == 1 || jubun2Obj.value.charAt(0) == 2) 
		{
			yearObj.value = "19" + jubun1Obj.value.substring(0, 2);
		} else if(jubun2Obj.value.charAt(0) == 3 || jubun2Obj.value.charAt(0) == 4)
		{
			yearObj.value = "20" + jubun1Obj.value.substring(0, 2);
		}
		monthObj.value = jubun1Obj.value.substring(2, 4);
		dateObj.value = jubun1Obj.value.substring(4, 6);
		
		
		alert("회원가입이 완료되었습니다.");
		

		document.join.submit();
	}
	
	// 아이디 유효성 검사
	function idVali()
	{
		if (userIdObj.value == "") 
		{
			alert("아이디를 입력해 주세요!");
			userIdObj.focus();
			return false;
		}
		if (!(re.test(userIdObj.value))) 
		{
			alert("아이디 형식을 확인해 주세요.");
			userIdObj.value = "";
			userIdObj.focus();
			return false;
		}
	}
	
	// 비밀번호 유효성 검사
	function pwVali()
	{
		if (userPwObj.value == "") 
		{
			alert("비밀번호를 입력해 주세요!");
			userPwObj.focus();
			return false;
		}
		
		if (userIdObj.value == userPwObj.value) 
		{
			alert("아이디와 비밀번호를 다르게 해주세요.");
			userPwObj.value = "";
			userPwObj.focus();
			return false;
		}
		
		if (!(re.test(userPwObj.value))) 
		{
			alert("비밀번호 형식을 확인해 주세요.");
			userPwObj.value = "";
			userPwObj.focus();
			return false;
		}
	}
	
	// 비밀번호 확인 유효성 검사
	function pwCoVali()
	{
		if (userPwConfirmObj.value == "") 
		{
			alert("비밀번호 확인을 입력해 주세요!")
			userPwConfirmObj.focus();
			return false;
		}
		if (userPwObj.value != userPwConfirmObj.value) 
		{
			alert("비밀번호랑 비밀번호 확인이 다릅니다.");
			userPwConfirmObj.focus();
			return false;
		}
	}
	
	// 이메일 유효성 검사
	function emailVali()
	{
		if (userEmailObj.value == "") 
		{
			alert("메일주소를 입력해 주세요!");
			userEmailObj.focus();
			return false;
		}
		
		if (!(re2.test(userEmailObj.value))) 
		{
			alert("메일주소 형식을 확인해 주세요.");
			userEmailObj.focus();
			return false;
		}
	}
	
	// 이름을 유효성 검사
	function nameVali()
	{
		if (userNameObj.value == "") 
		{
			alert("이름을 입력해 주세요!");
			userNameObj.focus();
			return false;
		}
	}
	
	// 주소 유효성 검사
	function addressVali()
	{
		if (roadAddressObj.value == "") 
		{
			alert("주소를 입력해 주세요");
			roadAddressObj.focus();
			return false;
		}
		
		if (subAddressObj.value == "") 
		{
			alert("상세 주소를 입력해 주세요");
			subAddressObj.focus();
			return false;
		}
	}
	
	// 주민번호 유효성 검사
	function juVali()
	{
		if (jubun1Obj.value == "") 
		{
			alert("주민번호를 입력해 주세요");
			jubun1Obj.focus();
			return false;
		}
		
		if (jubun2Obj.value == "") 
		{
			alert("주민번호를 입력해 주세요");
			jubun2Obj.focus();
			return false;
		}
		
		for (var i = 0; i < jubun1Obj.value.length; i++) 
		{
			arrjubun1[i] = jubun1Obj.value.charAt(i);
			arrjubun1[i] = arrjubun1[i] * (i+2);
			
			result += arrjubun1[i];
		}
		
		var cnt = 8;
		
		for (var i = 0; i < jubun2Obj.value.length-1; i++) 
		{
			arrjubun2[i] = jubun2Obj.value.charAt(i);
			arrjubun2[i] = arrjubun2[i] * (cnt++);
			
			if (cnt==10) 
				cnt=2;
				
			result += arrjubun2[i];
		}
		
		result %= 11;	
		result = 11 - result;
		
		/*if(result == jubun2Obj.value.charAt(6))
		{
			
		}*/
		
		if (result != jubun2Obj.value.charAt(6))
		{
			alert("주민번호가 잘못 되었습니다.");
			return false;
		}
	}
	
	// 취미 유효성 검사
	function hobbyVali()
	{
		var cnt = 0;
		
		for (var i = 0; i < hobbyObj.length; i++) 
		{
			if (hobbyObj[i].checked) 
			{
				cnt++;
			}
		}
		
		if (cnt == 0)
		{
			alert("취미 선택해 주세요 좀...");		
			return false;
		}
	}
	
	// 자기소개 유효성 검사
	function introVali()
	{
		if (introObj.value == "") {
			alert("자기소개를 입력해 주세요")
			introObj.focus();
			return false;
		}
	}
	
	
	
