package point.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;
import point.dto.PointHistoryDto;


public class PointHistoryCommand implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PointDao dao = new PointDao();
		ArrayList<PointHistoryDto> dtos = dao.PointHistory();
		request.setAttribute("PointHistory", dtos);	
		
		// 페이징 테스트용 
		int count = dao.PointPagingCount();
		request.setAttribute("count", count);
		
	} 
	
	
	
	
	
}
