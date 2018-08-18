package BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardDeleteCommand implements BoardCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = session.getAttribute("sessionID").toString();
		
		int writenum = Integer.parseInt( req.getParameter("writenum").toString());
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardBean board = dao.getBoardDetail(writenum);
		int msg = dao.deleteBoard(board, id);
		req.setAttribute("msg", msg);
	}
}
