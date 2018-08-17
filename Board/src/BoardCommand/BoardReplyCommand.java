package BoardCommand;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import DTO.BoardBean;

public class BoardReplyCommand implements BoardCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
	       
	        BoardDAO boarddao = BoardDAO.getInstance();
	        BoardBean boarddata = new BoardBean(); 
	        int result=0; 
	         
	        boarddata.setWriteNum(Integer.parseInt(req.getParameter("writenum"))); 
	        boarddata.setAuthor(req.getParameter("id")); 
	        boarddata.setSubject(req.getParameter("subject")); 
	        boarddata.setContent(req.getParameter("content")); 
	        boarddata.setReGroup(Integer.parseInt(req.getParameter("regroup"))); 
	        boarddata.setReLevel(Integer.parseInt(req.getParameter("relevel"))); 
	        boarddata.setReSequence(Integer.parseInt(req.getParameter("reseq"))); 
	         
	        try {
				result=boarddao.boardReply(boarddata);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	        
	        
	        if(result==0){ 
	            System.out.println("답장 실패"); 
	       //     return null; 
	        } 
	        System.out.println("답장 완료"); 
	         
	     
	     //   forward.setPath("./BoardDetailAction.bo?num="+result);         	
	}

}
