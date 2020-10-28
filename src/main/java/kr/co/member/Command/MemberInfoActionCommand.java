package kr.co.member.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DAO.MemberDAO;
import kr.co.DTO.MemberDTO;

public class MemberInfoActionCommand implements Command
{
	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId = request.getParameter("userId");
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = memberDAO.memberInfo(userId);
		System.out.println(memberDTO.toString());
		
		model.addAttribute("Member", memberDTO);
		
	}
}
