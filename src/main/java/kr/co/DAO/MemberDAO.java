package kr.co.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import kr.co.DTO.MemberDTO;
import kr.co.Util.Constant;

public class MemberDAO
{
	public JdbcTemplate template;
	
	@Autowired
	public MemberDAO()
	{
		this.template = Constant.template;
	}
	

	// 회원가입
	public void JoinProcess(final MemberDTO memberDTO)
	{
		template.update(new PreparedStatementCreator()
		{
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException
			{
				String sql = "INSERT INTO MEMBERINFORMATION VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, memberDTO.getUserId());
				pstmt.setString(2, memberDTO.getUserPw());
				pstmt.setString(3, memberDTO.getUserMail());
				pstmt.setString(4, memberDTO.getUserName());
				pstmt.setInt(5, memberDTO.getPostalCode());
				pstmt.setString(6, memberDTO.getRoadAddress());
				pstmt.setString(7, memberDTO.getBranchAddress());
				pstmt.setString(8, memberDTO.getSubAddress());
				pstmt.setString(9, memberDTO.getJubun1());
				pstmt.setString(10, memberDTO.getJubun2());
				pstmt.setString(11, memberDTO.getHobby());
				pstmt.setString(12, memberDTO.getIntro());
				
				return pstmt;
			}
		});
	}
	
	// 로그인
	public String login(String userId) 
	{
		String sql = "SELECT USERPW FROM MEMBERINFORMATION WHERE USERID = ?";
		
		// 스프링 4 버전 사용가능
		return template.queryForObject(sql, String.class, userId);
	}
	
	
	// 전체 회원조회
	public List<String> memberLookup()
	{
		String sql = "SELECT USERID FROM MEMBERINFORMATION";
		
		return template.queryForList(sql, String.class);
	}
	
	// 회원 정보 출력
	public MemberDTO memberInfo(String userId)
	{
		String sql = "SELECT * FROM MEMBERINFORMATION WHERE USERID = '"+userId+"'";
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}
	
	
	// 회원 삭제
	public void memberDelete(String userId)
	{
		String sql = "DELETE FROM MEMBERINFORMATION WHERE USERID = '"+ userId + "'";
		template.update(sql);
	}
	
	
}
