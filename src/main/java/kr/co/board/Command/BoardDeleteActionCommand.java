package kr.co.board.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DAO.BoardDAO;

public class BoardDeleteActionCommand implements Command
{

	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		BoardDAO boardDAO = new BoardDAO();
		
		boolean result=false;
	   	boolean usercheck=false;
	   	System.out.println(request.getParameter("num"));
	   	System.out.println(request.getParameter("BOARD_PASS"));
	   	
	   	int num=Integer.parseInt(request.getParameter("num"));
	   	String BOARD_PASS = request.getParameter("BOARD_PASS");
	   	
	   	String pass = boardDAO.isBoardWriter(num);
	   	if (BOARD_PASS.equals(pass))
	   		usercheck = true;
	   	
	   	
	   	boardDAO.boardDelete(num);
	   	
	}

}
