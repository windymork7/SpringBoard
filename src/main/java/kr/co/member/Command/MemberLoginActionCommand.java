package kr.co.member.Command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import kr.co.DAO.MemberDAO;

public class MemberLoginActionCommand implements Command
{
	@Override
	public void execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		MemberDAO memberDAO = new MemberDAO();
		String userPw2 = memberDAO.login(userId);
		
		if (userPw.equals(userPw2))
			session.setAttribute("userId", userId);
		
	}
}
