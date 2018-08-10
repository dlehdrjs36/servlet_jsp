package point.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import point.dao.PointDao;
import point.dto.PointDto;

public class PointUserCommand implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
    	
    	
		PointDao dao = new PointDao();
		HttpSession session = request.getSession();
		//테스트 세션
		session.setAttribute("sessionID", "pk");
		//
		String sessionID = (String) session.getAttribute("sessionID");
		System.out.println(sessionID);
		ArrayList<PointDto> dtos = dao.PointUser(sessionID); 
		request.setAttribute("userpoint", dtos);
		
	}
}
