package point.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;
import point.dto.Paging;
import point.dto.PointHistoryDto;
import point.dto.PointPageDto;

public class test implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 페이징 테스트용
					
					PointDao dao = new PointDao();
					//PointPageDto pdto = new PointPageDto();
					//pdto.setTotalCount(dao.PointTotalCount()); // 페이징 생성
					
					
					//ArrayList<PointHistoryDto> dtos = dao.PointGetList( pdto.getStartRowNo(), pdto.getEndRowNo());
					//System.out.println(pdto.getStartRowNo());
					//System.out.println(pdto.getEndRowNo());
					
					//request.setAttribute("plist", dtos); // 출력할 목록 리스트
					// 페이징 처리
					//request.setAttribute("paging", pdto);
					int page = 1;
			        if(request.getParameter("page")!=null){
			            page = Integer.parseInt(request.getParameter("page"));
			        }
			        Paging paging = new Paging();
			        paging.setPage(page);
			        paging.setTotalCount(dao.PointTotalCount());
			        ArrayList<PointHistoryDto> dtos = dao.PointGetList( page );

			        request.setAttribute("memList", dtos); // 출력할 데이터
			        request.setAttribute("paging", paging); // 총데이터량을 페이징처리			     
	}
}
