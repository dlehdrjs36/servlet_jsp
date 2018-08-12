package point.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;

public class PointUpdateUseCommand implements PointCommand {
//관리자가 유저의 포인트 사용관리.
	private static int error_code;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			PrintWriter out;
			String id = request.getParameter("id");
			int save = Integer.parseInt(request.getParameter("save"));
			PointDao dao = new PointDao();
			error_code = dao.UpdateUsePoint( id, save);
			
			request.setAttribute("error", error_code);		
	}

} 
