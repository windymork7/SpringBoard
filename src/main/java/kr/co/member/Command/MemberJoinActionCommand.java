package kr.co.member.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DAO.MemberDAO;
import kr.co.DTO.MemberDTO;

public class MemberJoinActionCommand implements Command
{
	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		MemberDTO memberDTO = (MemberDTO) map.get("memberDTO");
		
		MemberDAO dao = new MemberDAO();
		dao.JoinProcess(memberDTO);
		
	}
}
