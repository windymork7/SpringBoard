package kr.co.member.Command;


import java.util.List;

import org.springframework.ui.Model;

import kr.co.DAO.MemberDAO;

public class MemberListActionCommand implements Command
{
	@Override
	public void execute(Model model)
	{
		MemberDAO memberDAO = new MemberDAO();
		
		List<String> list = memberDAO.memberLookup();
		
		model.addAttribute("list", list);
		
	}
}
