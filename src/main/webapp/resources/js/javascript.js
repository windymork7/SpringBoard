function Preview()
	{
		var HandwritingObj = document.getElementById("Handwriting");
		var colorObj = document.getElementById("color");
		var fontObj = document.getElementById("font");
		var attriObj = document.getElementsByName("attri");
		var hereObj = document.getElementById("here");
		var result = HandwritingObj.value;
				
		
		if (colorObj.value == "green")
		{
			hereObj.style.color = "green";
		} else if (colorObj.value == "red")
		{
			hereObj.style.color = "red";
		} else if (colorObj.value == "blue")
		{
			hereObj.style.color = "blue";
		}
		
		
		if (fontObj.value == 1) 
		{
			hereObj.style.fontSize = 5 + "px";
		} else if(fontObj.value == 2)
		{
			hereObj.style.fontSize = 10 + "px";
		} else if(fontObj.value == 3)
		{
			hereObj.style.fontSize = 15 + "px";
		} else if(fontObj.value == 4)
		{
			hereObj.style.fontSize = 20 + "px";
		} else if(fontObj.value == 5)
		{
			hereObj.style.fontSize = 25 + "px";
		} else if(fontObj.value == 6)
		{
			hereObj.style.fontSize = 30 + "px";
		}
		
		if (attriObj[0].checked) 
		{
			result = result.strike();
		}
		
		if (attriObj[1].checked) 
		{
			hereObj.style.fontSize = "xx-large";
		} else if (attriObj[2].checked) 
		{
			hereObj.style.fontSize = "xx-small";
		}
		
		if (attriObj[3].checked) 
		{
			hereObj.style.fontWeight = "bold";
		} 
		
		if (attriObj[4].checked) 
		{
			hereObj.style.fontStyle = "italic";
		}
		
		if (attriObj[5].checked) 
		{
			result = result.sup();
		} else if (attriObj[6].checked)
		{
			result = result.sub();
		}
		
		if (attriObj[7].checked) 
		{
			result = result.toLowerCase();
		} else if(attriObj[8].checked)
		{
			result = result.toUpperCase();
		}
		
		hereObj.innerHTML=result;
	}