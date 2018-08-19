package BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardUpdateFormCommand implements BoardCommand {
// 글 수정JSP에 뿌려줄 데이터
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int writeNum = Integer.parseInt(req.getParameter("writenum").toString()) ;
		BoardDAO dao = BoardDAO.getInstance();	
		BoardBean boardBean = dao.getBoardDetail(writeNum);
		req.setAttribute("BoardBean", boardBean);	
	}
 
}
