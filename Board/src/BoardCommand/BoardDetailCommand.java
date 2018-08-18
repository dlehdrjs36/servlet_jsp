package BoardCommand;

import java.sql.SQLException;

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
		// 조회수를 얻어와서 수정하는 부분
		int readCount = boardBean.getReadCount();
		readCount = readCount+1;
		boardBean.setReadCount(readCount);
		try {
			dao.UpdateCountBoard(boardBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("BoardBean", boardBean);
	}

}
