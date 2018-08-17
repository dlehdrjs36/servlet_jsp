package PointCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PointDAO;
import DTO.PointPagingBean;
import DTO.PointHistoryBean;

public class PointHistoryCommand implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {				
			PointDAO dao = new PointDAO();
					
			int page = 1;
		    if(request.getParameter("page")!=null){
		        page = Integer.parseInt(request.getParameter("page"));
		    }
		    PointPagingBean paging = new PointPagingBean();
		    paging.setPage(page);
		    paging.setTotalCount(dao.PointHistoryTotalCount());
		    ArrayList<PointHistoryBean> dtos = dao.PointGetPointHistoryList( page );

		    request.setAttribute("PointHistory", dtos); // 출력할 데이터
		    request.setAttribute("paging", paging); // 총데이터량을 페이징처리
		    request.setAttribute("check", 1); // 총데이터량을 페이징처리	
			        
	}
}
