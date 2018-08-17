package PointCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PointDAO;
import DTO.PointHistoryBean;
import DTO.PointPagingBean;

public class PointSearchListCommand implements PointCommand {
// 조건을 주어서 회원이력 검색.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PointDAO dao = new PointDAO();
		int page = 1;
		String subjects = request.getParameter("subjects");
		String search = request.getParameter("search");	
		//페이징
		if(request.getParameter("page") !=null){
	        page = Integer.parseInt(request.getParameter("page"));        
	    }
		
		PointPagingBean paging = new PointPagingBean();
		paging.setSubjects(subjects);
		paging.setSearch(search);	
		int totalcount = dao.PointHistorySearchTotalCount(paging.getSubjects(), paging.getSearch());		
        paging.setPage(page);    
        paging.setTotalCount(totalcount);             
        ArrayList<PointHistoryBean> dtos = dao.PointSearchList( paging , page);

        request.setAttribute("PointHistory", dtos); // 출력할 데이터
        request.setAttribute("paging", paging); // 총데이터량을 페이징처리
        request.setAttribute("check", 2);		// 동작
        request.setAttribute("totalcount", paging.getTotalCount()); // 총데이터량을 페이징처리
	}
 
}
