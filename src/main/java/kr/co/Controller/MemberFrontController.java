package kr.co.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.DTO.MemberDTO;
import kr.co.Util.Constant;
import kr.co.member.Command.Command;
import kr.co.member.Command.MemberDeleteActionCommand;
import kr.co.member.Command.MemberJoinActionCommand;
import kr.co.member.Command.MemberListActionCommand;
import kr.co.member.Command.MemberLoginActionCommand;
import kr.co.member.Command.MemberInfoActionCommand;

@Controller
public class MemberFrontController
{
	Command command = null;
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template)
	{
		this.template = template;
		Constant.template = this.template;
	}
	
	
	// 시작페이지를 로그인 폼으로 이동
	@RequestMapping("/")
	public String start()
	{
		return "member/loginForm";
	}
	
	// 로그인 폼으로 이동 
	@RequestMapping("/loginForm")
	public String loginForm()
	{
		return "member/loginForm";
	}
	
	// 회원가입 폼으로 이동
	@RequestMapping("/MemberJoin.me")
	public String joinForm()
	{
		return "member/joinForm";
	}
	
	// 회원가입 처리
	@RequestMapping(value = "/MemberJoinProcess.me", method = RequestMethod.POST)
	public String joinprocess(HttpServletRequest request, Model model, MemberDTO memberDTO)
	{
		model.addAttribute("request", request);
		model.addAttribute("memberDTO", memberDTO);
		command = new MemberJoinActionCommand();
		command.execute(model);
		
		return "redirect:loginForm";
	}
	
	// 로그인 처리
	@RequestMapping(value="/loginProcess.me", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new MemberLoginActionCommand();
		command.execute(model);
		
		return "member/main";
	}
	
	
	// 회원조회
	@RequestMapping("/Member_list.me")
	public String member_list(Model model)
	{
		command = new MemberListActionCommand();
		command.execute(model);
		
		return "member/member_list";
	}
	
	// 한사람 회원정보
	@RequestMapping("/MemberInfo.me")
	public String member_info(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new MemberInfoActionCommand();
		command.execute(model);
		
		return "member/member_into";
	}
	
	// 회원삭제
	@RequestMapping("/MemberDelete.me")
	public String member_delete(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		command = new MemberDeleteActionCommand();
		command.execute(model);

		return "redirect:Member_list.me";
	}
	
}
