package MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MemberDAO;

public class MemberLoginCommand implements MemberCommand {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	    
		// 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
        String id= req.getParameter("id");
        String pw = req.getParameter("password");
        // DB에서 아이디, 비밀번호 확인
        MemberDAO dao = MemberDAO.getInstance();
        int check = dao.loginMember(id, pw);
        // URL 및 로그인관련 전달 메시지
        String msg = "";
        if(check == 1)    // 로그인 성공
        { 
            // 세션에 현재 아이디 세팅
        	HttpSession session = req.getSession();
        	session.setAttribute("sessionID", id);
            msg = "/MainForm.jsp?msg=1";
            req.setAttribute("msg", msg);
        }
        else if(check == 0) // 비밀번호가 틀릴경우
        {
            msg = "/MainForm.do?contentPage=/member/view/MemberLoginForm.jsp?msg=0";
            req.setAttribute("msg", msg);
        }
	}
}
