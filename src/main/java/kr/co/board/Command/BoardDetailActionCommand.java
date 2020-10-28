package kr.co.board.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DAO.BoardDAO;
import kr.co.DTO.BoardDTO;

public class BoardDetailActionCommand implements Command
{

	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		BoardDTO boardDTO = new BoardDTO();
		BoardDAO boardDAO = new BoardDAO();
		
		int num=Integer.parseInt(request.getParameter("num"));
		boardDAO.setReadCountUpdate(num);
		boardDTO = boardDAO.getDetail(num);
		
		model.addAttribute("boardDTO", boardDTO);
		
	}

}
