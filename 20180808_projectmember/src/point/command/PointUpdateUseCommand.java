package point.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;

public class PointUpdateUseCommand implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

			String id = request.getParameter("id");
			int save = Integer.parseInt(request.getParameter("save"));
			PointDao dao = new PointDao();

			dao.UpdateUsePoint( id, save);
		
	}

}
