package kr.co.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import kr.co.DTO.BoardDTO;
import kr.co.Util.Constant;

public class BoardDAO
{
	public JdbcTemplate template;
	
	public BoardDAO()
	{
		template = Constant.template;
	}
	
	// 전체 행 수
	public int getListCount()
	{
		String sql = "SELECT COUNT(*) FROM BOARD";
		
		return template.queryForInt(sql);
	}
	
	
	// 페이지 행 리스트
	public List<BoardDTO> getBoardList(int page,int limit)
	{
		int startrow=(page-1)*10+1;
		int endrow=startrow+limit-1;
		
		String sql = "SELECT * FROM "
				+ "(SELECT ROWNUM RNUM,BOARD_NUM,BOARD_NAME,BOARD_SUBJECT, BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV, BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE"
				+ " FROM (SELECT * FROM BOARD ORDER BY BOARD_RE_REF DESC,BOARD_RE_SEQ ASC)) WHERE RNUM>="+startrow+" AND RNUM<="+endrow;
		
		return template.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	
	public int maxPoint()
	{
		String sql = "SELECT MAX(BOARD_NUM) FROM BOARD";
		return template.queryForInt(sql);
	}
	
	
	// 글쓰기
	public void boardInsert(final BoardDTO boardDTO)
	{
		final int NUM = maxPoint()+1;
		
		
		template.update(new PreparedStatementCreator()
		{
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException
			{
				String sql = "INSERT INTO BOARD (BOARD_NUM,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE) VALUES(?,?,?,?,?,?,?,?,?,?,SYSDATE)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, NUM);
				pstmt.setString(2, boardDTO.getBOARD_NAME());
				pstmt.setString(3, boardDTO.getBOARD_PASS());
				pstmt.setString(4, boardDTO.getBOARD_SUBJECT());
				pstmt.setString(5, boardDTO.getBOARD_CONTENT());
				pstmt.setString(6, boardDTO.getBOARD_FILE());
				pstmt.setInt(7, NUM);
				pstmt.setInt(8, 0);
				pstmt.setInt(9, 0);
				pstmt.setInt(10, 0);
				
				System.out.println(boardDTO.toString());
				
				return pstmt;
			}
		});
	}
	
	// 조회수
	public void setReadCountUpdate(int num)
	{
		String sql="UPDATE BOARD SET BOARD_READCOUNT = "+
				"BOARD_READCOUNT+1 WHERE BOARD_NUM = "+num;
		template.update(sql);
	}
	
	// 한개 조회
	public BoardDTO getDetail(int num)
	{
		String sql = "SELECT * FROM BOARD WHERE BOARD_NUM = "+ num;
		
		return template.queryForObject(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	
	public String isBoardWriter(int num)
	{
		String sql = "SELECT BOARD_PASS FROM BOARD WHERE BOARD_NUM=?";
		
		return template.queryForObject(sql, String.class, num);
	}
	
	// 글삭제
	public void boardDelete(int num)
	{
		String sql = "DELETE FROM BOARD WHERE BOARD_NUM="+ num;
		
		template.update(sql);
	}
	
}
