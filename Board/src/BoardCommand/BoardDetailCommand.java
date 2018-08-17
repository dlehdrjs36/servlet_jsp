package BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardBean;


public class BoardDetailCommand implements BoardCommand{
// 수정 버튼에 사용되었음.
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	
		int writeNum = Integer.parseInt(req.getParameter("writenum").toString()) ;
		BoardDAO dao = BoardDAO.getInstance();	
		BoardBean boardBean = dao.getBoardDetail(writeNum);
			
		req.setAttribute("BoardBean", boardBean);
	}

}
