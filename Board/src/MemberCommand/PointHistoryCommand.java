package MemberCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PointDao;
import DTO.PointPagingDto;
import DTO.PointHistoryDto;
import DTO.PointPagingDto;

public class PointHistoryCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub					
					PointDao dao = new PointDao();
					
					int page = 1;
			        if(request.getParameter("page")!=null){
			            page = Integer.parseInt(request.getParameter("page"));
			        }
			        PointPagingDto paging = new PointPagingDto();
			        paging.setPage(page);
			        paging.setTotalCount(dao.PointHistoryTotalCount());
			        ArrayList<PointHistoryDto> dtos = dao.PointGetPointHistoryList( page );

			        request.setAttribute("PointHistory", dtos); // 출력할 데이터
			        request.setAttribute("paging", paging); // 총데이터량을 페이징처리
			        request.setAttribute("check", 1); // 총데이터량을 페이징처리	
			        
	}
}
