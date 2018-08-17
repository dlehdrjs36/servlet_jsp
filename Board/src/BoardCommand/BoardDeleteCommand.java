package BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;

public class BoardDeleteCommand implements BoardCommand{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		String id = session.getAttribute("sessionID").toString();
		
		int writenum = Integer.parseInt( req.getParameter("writenum").toString());
<<<<<<< HEAD
		
=======
		System.out.println("id : "+id );
		System.out.println("writenum : "+writenum );
>>>>>>> refs/remotes/origin/master
		BoardDAO dao = BoardDAO.getInstance();
		int msg = dao.deleteBoard(writenum, id);
		req.setAttribute("msg", msg);
	}
}
