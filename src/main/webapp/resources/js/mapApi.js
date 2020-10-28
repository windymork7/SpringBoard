//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() 
    {
        new daum.Postcode({
            oncomplete: function(data) 
            {

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('Postal code').value = data.zonecode;
                document.getElementById("Road address").value = data.roadAddress;
                document.getElementById("branch address").value = data.jibunAddress;
                

            }
        }).open();
    }