package point.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import point.dao.PointDao;

public class PointInsertCommand implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		// TODO Auto-generated method stub

			String id = request.getParameter("id");
			int save = Integer.parseInt(request.getParameter("save"));
			PointDao dao = new PointDao();
			
			try {
				dao.InsertPoint( id, save);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}


}
