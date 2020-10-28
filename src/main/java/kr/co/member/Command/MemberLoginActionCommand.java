package kr.co.member.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import kr.co.DAO.MemberDAO;

public class MemberLoginActionCommand implements Command
{
	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId = request.getParameter("userId");
		
		
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.login(userId);
		
		
		
		
	}
}
