package point.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;
import point.dto.PointDto;
import point.dto.PointHistoryDto;
import point.dto.PointPagingDto;

public class PointSearchListCommand implements PointCommand {
// 조건을 주어서 회원이력 검색.
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		PointDao dao = new PointDao();
		int page = 1;
		int subject = 0;
		String subjects = request.getParameter("subjects");
		String search = request.getParameter("search");
		System.out.println("subject = " + subjects + " search = " + search);
		
		if(subjects != null) {
		subject = Integer.parseInt(subjects);	
		}		
		//페이징
		if(request.getParameter("page") !=null){
	        page = Integer.parseInt(request.getParameter("page"));        
	    }		    				
		PointPagingDto paging = new PointPagingDto();
		paging.setSubjects(subject);
		paging.setSearch(request.getParameter("search"));	
		int totalcount = dao.PointHistorySearchTotalCount(paging.getSubjects(), paging.getSearch());		
        paging.setPage(page);    
        paging.setTotalCount(totalcount);
        System.out.println("page = " + page + " totalcount = " + totalcount);
             
        ArrayList<PointHistoryDto> dtos = dao.PointSearchList( paging , page);

        request.setAttribute("PointHistory", dtos); // 출력할 데이터
        request.setAttribute("paging", paging); // 총데이터량을 페이징처리
        request.setAttribute("check", 2);		// 동작
        request.setAttribute("totalcount", paging.getTotalCount()); // 총데이터량을 페이징처리
	}
 
}
