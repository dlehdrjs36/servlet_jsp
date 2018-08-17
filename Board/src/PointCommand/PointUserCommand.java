package PointCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PointDAO;
import DTO.PointBean;

public class PointUserCommand implements PointCommand {
// 유저 자기자신의 남은포인트 확인.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PointDAO dao = new PointDAO();
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		ArrayList<PointBean> dtos = dao.PointUser(sessionID);
		
		session.getAttribute("sessionID");
		request.setAttribute("userpoint", dtos);
		
	}
}
