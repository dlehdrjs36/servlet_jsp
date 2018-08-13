package MemberCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PointDao;
import DTO.PointDto;

public class PointUserCommand implements MemberCommand {
// 유저 자기자신의 남은포인트 확인.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PointDao dao = new PointDao();
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		ArrayList<PointDto> dtos = dao.PointUser(sessionID);
		
		session.getAttribute("sessionID");
		request.setAttribute("userpoint", dtos);
		
	}
}
