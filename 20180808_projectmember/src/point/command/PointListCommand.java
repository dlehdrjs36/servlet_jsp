package point.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;
import point.dto.PointDto;

public class PointListCommand implements PointCommand {
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PointDao dao = new PointDao();
		ArrayList<PointDto> dtos = dao.PointList();
		request.setAttribute("PointList", dtos);	
	}
	

}
