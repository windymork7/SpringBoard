package kr.co.board.Command;

import java.util.Map;

import org.springframework.ui.Model;

import kr.co.DAO.BoardDAO;
import kr.co.DTO.BoardDTO;

public class BoardReplyActionCommand implements Command
{

	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		BoardDTO boardDTO = (BoardDTO) map.get("boardDTO");

		BoardDAO boardDAO = new BoardDAO();
		
		boardDAO.boardReply(boardDTO);
		
	}

}
