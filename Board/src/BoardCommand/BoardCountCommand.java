package BoardCommand;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardCountCommand implements BoardCommand {
// 카운트 관리
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		int writeNum = Integer.parseInt(req.getParameter("writenum").toString()) ;
		int readCount = Integer.parseInt(req.getParameter("count").toString());
		readCount = readCount+1;
		
		BoardDAO dao = BoardDAO.getInstance();	
		BoardBean boardBean = dao.getBoardDetail(writeNum);
		boardBean.setReadCount(readCount);	
		try {
			dao.UpdateCountBoard(writeNum, boardBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("BoardBean", boardBean);
	}

}
