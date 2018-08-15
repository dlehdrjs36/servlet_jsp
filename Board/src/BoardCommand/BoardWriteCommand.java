package BoardCommand;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardWriteCommand implements BoardCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		BoardBean bean = new BoardBean();
		HttpSession session = req.getSession();
		String id = session.getAttribute("sessionID").toString();
		bean.setAuthor(id);
		bean.setSubject(req.getParameter("subject"));
		bean.setContent(req.getParameter("content"));
		BoardDAO dao = BoardDAO.getInstance();
		try {
			dao.WriteBoard(bean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
