package PointCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PointDAO;

public class PointUpdateSaveCommand implements PointCommand {
// 愿�由ъ옄媛� �쑀���쓽 �룷�씤�듃 �쟻由쎄�由�.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
			PointDAO dao = new PointDAO();	
			String id = request.getParameter("id");
			String save = request.getParameter("save");
			int save2 = 0;
			int totalcount = dao.PointCheck(id);			
			
			if(save != null) save2 = Integer.parseInt(save);
			if(totalcount !=0 ) dao.UpdateSavePoint( id, save2);
			
     		request.setAttribute("totalcount", totalcount ); // �븘�씠�뵒�솗�씤�빐�꽌 �빐�떦�븯�뒗id�엲�뒗吏� �솗�씤.
	}
}
 