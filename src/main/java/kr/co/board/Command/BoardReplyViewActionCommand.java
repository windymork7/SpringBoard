package kr.co.board.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DAO.BoardDAO;
import kr.co.DTO.BoardDTO;

public class BoardReplyViewActionCommand implements Command
{

	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		BoardDAO boardDAO = new BoardDAO();
		BoardDTO boardDTO = new BoardDTO();
		
		int num=Integer.parseInt(request.getParameter("num"));
		
		boardDTO = boardDAO.getDetail(num);
		
		model.addAttribute("boardDTO", boardDTO);
	}

}
