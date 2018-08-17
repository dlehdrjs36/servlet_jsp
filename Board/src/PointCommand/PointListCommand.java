package PointCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PointDAO;
import DTO.PointBean;
import DTO.PointPagingBean;

public class PointListCommand implements PointCommand {
//관리자가 전체 유저의 정보확인.
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		PointDAO dao = new PointDAO();		
		int page = 1;
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        PointPagingBean paging = new PointPagingBean();
        paging.setPage(page);
        paging.setTotalCount(dao.PointListTotalCount());
        ArrayList<PointBean> dtos = dao.PointGetPointList( page );

        request.setAttribute("PointList", dtos); 
        request.setAttribute("paging", paging); 
        request.setAttribute("check", 3); // 동작		
        
	}
}
 