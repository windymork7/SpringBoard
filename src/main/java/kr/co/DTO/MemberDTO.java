package kr.co.DTO;

public class MemberDTO
{
	private String userId;
	private String userPw;
	private String userMail;
	private String userName;
	private int postalCode;
	private String roadAddress;
	private String branchAddress;
	private String subAddress;
	private String jubun1;
	private String jubun2;
	private String hobby;
	private String intro;

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getUserPw()
	{
		return userPw;
	}

	public void setUserPw(String userPw)
	{
		this.userPw = userPw;
	}

	public String getUserMail()
	{
		return userMail;
	}

	public void setUserMail(String userMail)
	{
		this.userMail = userMail;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getPostalCode()
	{
		return postalCode;
	}

	public void setPostalCode(int postalCode)
	{
		this.postalCode = postalCode;
	}

	public String getRoadAddress()
	{
		return roadAddress;
	}

	public void setRoadAddress(String roadAddress)
	{
		this.roadAddress = roadAddress;
	}

	public String getBranchAddress()
	{
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress)
	{
		this.branchAddress = branchAddress;
	}

	public String getSubAddress()
	{
		return subAddress;
	}

	public void setSubAddress(String subAddress)
	{
		this.subAddress = subAddress;
	}

	public String getJubun1()
	{
		return jubun1;
	}

	public void setJubun1(String jubun1)
	{
		this.jubun1 = jubun1;
	}

	public String getJubun2()
	{
		return jubun2;
	}

	public void setJubun2(String jubun2)
	{
		this.jubun2 = jubun2;
	}

	public String getHobby()
	{
		return hobby;
	}

	public void setHobby(String hobby)
	{
		this.hobby = hobby;
	}

	public String getIntro()
	{
		return intro;
	}

	public void setIntro(String intro)
	{
		this.intro = intro;
	}

	@Override
	public String toString()
	{
		return "클래스명 : [MemberBean], 필드[userId : " + userId + ", userPw : " + userPw + ", userMail : " + userMail
				+ ", userName : " + userName + ", postalCode : " + postalCode + ", roadAddress : " + roadAddress
				+ ", branchAddress : " + branchAddress + ", subAddress : " + subAddress + ", jubun1 : " + jubun1
				+ ", jubun2 : " + jubun2 + ", hobby : " + hobby + ", intro : " + intro + "]";
	}

	
}
