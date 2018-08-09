package point.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;
import point.dto.PointHistoryDto;
import point.dto.PointPageDto;

public class test implements PointCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		// 페이징 테스트용 
					PointDao dao = new PointDao();
					PointPageDto pdto = new PointPageDto();
					int totalCount = dao.PointTotalCount();
					pdto.setTotalCount(totalCount);
					
					ArrayList<PointHistoryDto> dtos = dao.PointGetList( pdto.getEndRowNo(), pdto.getStartRowNo());
					System.out.println(pdto.getStartRowNo());
					System.out.println(pdto.getEndRowNo());
					request.setAttribute("plist", dtos);
					request.setAttribute("paging", pdto);
	}

}
