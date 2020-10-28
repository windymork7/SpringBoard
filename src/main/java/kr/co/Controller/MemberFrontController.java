package kr.co.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.DTO.MemberDTO;
import kr.co.Util.Constant;
import kr.co.member.Command.Command;
import kr.co.member.Command.MemberJoinActionCommand;

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
	
	@RequestMapping(value="loginProcess.me", method = RequestMethod.POST)
	public String loginProcess(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		
		
		return "member/main";
	}
	
	
	
	
}
