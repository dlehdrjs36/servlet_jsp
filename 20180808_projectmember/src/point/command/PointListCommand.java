package point.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;
import point.dto.PointDto;
import point.dto.PointHistoryDto;
import point.dto.PointPagingDto;

public class PointListCommand implements PointCommand {
//관리자가 전체 유저의 정보확인.
	
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
        paging.setTotalCount(dao.PointListTotalCount());
        ArrayList<PointDto> dtos = dao.PointGetPointList( page );

        request.setAttribute("PointList", dtos); // 출력할 데이터
        request.setAttribute("paging", paging); // 총데이터량을 페이징처리
        request.setAttribute("check", 3); // 총데이터량을 페이징처리		
        
	}
}
 