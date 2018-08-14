package MemberCommand;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PointDao;

public class PointUpdateUseCommand implements MemberCommand {
//관리자가 유저의 포인트 사용관리.
	private static int error_code;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

			PointDao dao = new PointDao();		
			String id = request.getParameter("id");
			String use = request.getParameter("use");
			int use2 = 0;
			int totalcount = dao.PointCheck(id);
			
			if(use != null) use2 = Integer.parseInt(use);			
			if(totalcount !=0 ) error_code = dao.UpdateUsePoint( id, use2); 
			
			request.setAttribute("error", error_code);
			request.setAttribute("totalcount", totalcount ); 
	}

} 
