package BoardCommand;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardUpdateCommand implements BoardCommand {
// 글 수정 
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		int writeNum = Integer.parseInt(req.getParameter("writenum").toString()) ;
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardBean boardBean = dao.getBoardDetail(writeNum);
		boardBean.setSubject(subject);
		boardBean.setContent(content);
		try {
			dao.UpdateBoard( boardBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
