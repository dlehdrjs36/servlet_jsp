package MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import DTO.MemberBean;

public class MemberInfoCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("sessionID");
		System.out.println(id);
		MemberDAO dao = MemberDAO.getInstance();
		MemberBean memberBean = dao.SearchMemberInfo(id);
		req.setAttribute("memberBean", memberBean);
	}

}
