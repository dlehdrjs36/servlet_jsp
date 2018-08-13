package MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;
import DTO.MemberBean;

public class MemberChangeInfoCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String msg;
		MemberBean memberBean = new MemberBean();
		memberBean.setPassword(req.getParameter("password"));
		memberBean.setEmail(req.getParameter("email"));
		memberBean.setName(req.getParameter("name"));
		memberBean.setBirthday(req.getParameter("birthday"));
		memberBean.setGender(req.getParameter("gender"));
		memberBean.setAddrnum(req.getParameter("addrnum"));
		memberBean.setAddr(req.getParameter("addr"));
		memberBean.setAddrdetail(req.getParameter("addrdetail"));
		memberBean.setTel1(req.getParameter("tel1"));
		memberBean.setTel2(req.getParameter("tel2"));
		memberBean.setTel3(req.getParameter("tel3"));
		HttpSession session = req.getSession();
		String id = session.getAttribute("sessionID").toString();
		String pw = req.getParameter("oldpassword").toString();
		MemberDAO dao = MemberDAO.getInstance();
		int check = dao.ChangeMemberInfo(id, pw, memberBean);
		if (check == 0) {
			msg="/MemberChangeInfoForm.do?msg=1";
			req.setAttribute("msg", msg);
		} else if (check == 1) {
			msg="/MemberInfoForm.do?msg=1";
			req.setAttribute("msg", msg);
		}

	}

}
