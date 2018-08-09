package point.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;
import point.dto.PointHistoryDto;

public class PointSearchListCommand implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String search = request.getParameter("search");
		String subjects = request.getParameter("subjects");
		int subject = 0;
		if(subjects != null) subject = Integer.parseInt(subjects);
		System.out.println(search);
		System.out.println(subjects);
		System.out.println(subject);
		
		PointDao dao = new PointDao();
		ArrayList<PointHistoryDto> dtos = dao.PointSearchList(search, subject);
		request.setAttribute("PointHistory", dtos);	
	}
 
}
