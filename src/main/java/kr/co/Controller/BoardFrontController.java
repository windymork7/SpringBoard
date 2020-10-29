package kr.co.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.DTO.BoardDTO;
import kr.co.Util.Constant;
import kr.co.board.Command.BoardDeleteActionCommand;
import kr.co.board.Command.BoardDetailActionCommand;
import kr.co.board.Command.BoardListActionCommand;
import kr.co.board.Command.BoardModifyActionCommand;
import kr.co.board.Command.BoardModifyViewActionCommand;
import kr.co.board.Command.BoardReplyActionCommand;
import kr.co.board.Command.BoardReplyViewActionCommand;
import kr.co.board.Command.BoardWriteActionCommand;
import kr.co.board.Command.Command;

@Controller
public class BoardFrontController
{
	Command command = null;
	
	private JdbcTemplate template;
	
	public BoardFrontController()
	{
		template = Constant.template;
	}
	
	// 글 전체 목록
	@RequestMapping("/BoardList.bo")	
	public String qna_board_list(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new BoardListActionCommand();
		command.execute(model);
		
		return "board/qna_board_list";
	}
	
	// 글쓰기 페이지 이동
	@RequestMapping("/BoardWrite.bo")
	public String qna_board_write()
	{
		return "board/qna_board_write";
	}
	
	
	// 글쓰기
	@RequestMapping(value="/BoardAddAction.bo")
	public String qna_board_writePro(BoardDTO boardDTO, Model model)
	{
		model.addAttribute("boarDTO", boardDTO);
		command = new BoardWriteActionCommand();
		command.execute(model);
		
		return "redirect:BoardList.bo";
	}
	
	
	// 글 한개 조회
	@RequestMapping("/BoardDetailAction.bo")
	public String qna_board_view(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new BoardDetailActionCommand();
		command.execute(model);
		
		return "board/qna_board_view";
	}
	
	// 글 삭제 페이지 이동
	@RequestMapping("/BoardDelete.bo")
	public String qna_board_delete(HttpServletRequest request, Model model)
	{
		model.addAttribute("num", request.getParameter("num"));
		return "board/qna_board_delete";
	}
	
	// 글 수정 페이지 이동
	@RequestMapping("/BoardModify")
	public String qna_board_modify(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new BoardModifyViewActionCommand();
		command.execute(model);
		
		return "board/qna_board_modify";
	}
	
	// 글 수정
	@RequestMapping("/BoardModifyAction.bo")
	public String board_modify(BoardDTO boardDTO, Model model)
	{
		model.addAttribute("boardDTO", boardDTO);
		command = new BoardModifyActionCommand();
		command.execute(model);
		
		return "redirect:BoardList.bo";
	}
	
	// 글 삭제
	@RequestMapping("/BoardDeleteAction.bo")
	public String board_delete(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new BoardDeleteActionCommand();
		command.execute(model);
		
		return "redirect:BoardList.bo";
	}
	
	
	// 댓글 페이지 이동
	@RequestMapping("/BoardReplyAction.bo")
	public String qna_board_reply(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new BoardReplyViewActionCommand();
		command.execute(model);
		
		return "board/qna_board_reply";
	}
	
	// 댓글 달기
	@RequestMapping("/BoardReplyView.bo")
	public String board_reply(BoardDTO boardDTO, Model model)
	{
		model.addAttribute("boardDTO", boardDTO);
		command = new BoardReplyActionCommand();
		command.execute(model);
		
		return "redirect:BoardList.bo";
	}
	
	
	
}
