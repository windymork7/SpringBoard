package kr.co.board.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DAO.BoardDAO;
import kr.co.DTO.BoardDTO;

public class BoardWriteActionCommand implements Command
{

	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		BoardDTO boardDTO = (BoardDTO) map.get("boardDTO"); 
		BoardDAO boardDAO = new BoardDAO(); 
   		
   		System.out.println(boardDTO.toString());
		
		boardDAO.boardInsert(boardDTO);
	}

}
