package BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardReplyFormCommand implements BoardCommand {
// 답글작성 폼으로 이동할때 받아온 부모글 값으로 상세정보를 얻어서 replyform에 뿌려줌.
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		BoardDAO dao = BoardDAO.getInstance();
        int writenum = Integer.parseInt(req.getParameter("writenum"));            
        BoardBean board = dao.getBoardDetail(writenum);        
        req.setAttribute("board", board);
	}

}
