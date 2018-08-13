package MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.PointDao;

public class PointUpdateSaveCommand implements MemberCommand {
// 관리자가 유저의 포인트 적립관리.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

			String id = request.getParameter("id");
			String save = request.getParameter("save");
			int save2 = 0;
			if(save != null) save2 = Integer.parseInt(save);
			PointDao dao = new PointDao();	
			dao.UpdateSavePoint( id, save2);	
	}
}
 