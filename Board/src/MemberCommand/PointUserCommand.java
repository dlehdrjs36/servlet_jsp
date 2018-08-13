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
		// TODO Auto-generated method stub	
    	
		PointDao dao = new PointDao();
		HttpSession session = request.getSession();
		//테스트 세션
		session.getAttribute("sessionID");
		//
		String sessionID = (String) session.getAttribute("sessionID");
		System.out.println(sessionID);
		ArrayList<PointDto> dtos = dao.PointUser(sessionID); 
		request.setAttribute("userpoint", dtos);
		
	}
}
