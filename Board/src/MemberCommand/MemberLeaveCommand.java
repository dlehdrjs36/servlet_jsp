package MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;

public class MemberLeaveCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = session.getAttribute("sessionID").toString();
		String pw = req.getParameter("password");
		MemberDAO dao = MemberDAO.getInstance();
		int check =dao.MemberLeave(id, pw);
		req.setAttribute("check", check);	
	}
}
