package BoardCommand;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardReplyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {      
	        BoardDAO boarddao = BoardDAO.getInstance();
	        BoardBean boarddata = new BoardBean();  
	        String id = req.getParameter("id");
	        String subject = req.getParameter("subject");
	        String content = req.getParameter("content");
	        int writenum = Integer.parseInt(req.getParameter("writenum"));
	        int regroup = Integer.parseInt(req.getParameter("regroup"));
	        int relevel = Integer.parseInt(req.getParameter("relevel"));
	        int reseq = Integer.parseInt(req.getParameter("reseq"));
	        boarddata.setWriteNum(writenum); 
	        boarddata.setAuthor(id); 
	        boarddata.setSubject(subject); 
	        boarddata.setContent(content); 
	        boarddata.setReGroup(regroup); 
	        boarddata.setReLevel(relevel); 
	        boarddata.setReSequence(reseq); 
	         
	        try {
				boarddao.boardReply(boarddata);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}              	
	}

}
