package FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PointCommand.PointCommand;
import PointCommand.PointHistoryCommand;
import PointCommand.PointHistoryDownCommand;
import PointCommand.PointListCommand;
import PointCommand.PointSearchListCommand;
import PointCommand.PointUpdateSaveCommand;
import PointCommand.PointUpdateUseCommand;
import PointCommand.PointUserCommand;

@WebServlet("*.po")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PointController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PointCommand command = null;
		
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		// 유저 자기자신의 포인트 정보 확인.
		if(com.equals("/PointUser.po")) { 
			command = new PointUserCommand();
			command.execute(request, response);
			viewPage = "MainForm.do?contentPage=/Point/PointUserView.jsp";
		// admin만 수행가능한 메뉴.
		} else if( session.getAttribute("sessionID").equals("admin")) {
			if(com.equals("/PointList.po")) { // 목록화면.
				command = new PointListCommand();
				command.execute(request, response);
				viewPage = "MainForm.do?contentPage=/Point/PointList.jsp";				
			}  	
			else if (com.equals("/PointUpdateSaveView.po")) { // 포인트 적립화면
				viewPage = "MainForm.do?contentPage=/Point/PointUpdateSave.jsp";
			}  
			else if (com.equals("/PointUpdateUseView.po")) { // 포인트 사용 화면
				viewPage = "MainForm.do?contentPage=/Point/PointUpdateUse.jsp";
			}  	
			else if(com.equals("/PointUpdateSave.po")) { // 포인트 적립 작업수행후 목록화면이동.
				command = new PointUpdateSaveCommand();
				command.execute(request, response);
				viewPage = "/PointList.po";
			}  
			else if(com.equals("/PointUpdateUse.po")) { // 포인트 사용 작업수행후 목록화면이동. 
				command = new PointUpdateUseCommand();
				command.execute(request, response);
				viewPage = "/PointList.po";
			}
			else if(com.equals("/PointHistoryDown.po")) { // 포인트사용이력 엑셀로 다운
				command = new PointHistoryDownCommand();
				command.execute(request, response);
				viewPage = "/PointHistory.po";
			}  
			else if ( com.equals("/PointHistory.po")) { // 포인트사용이력화면
				command = new PointHistoryCommand(); 
				command.execute(request, response);
				viewPage = "MainForm.do?contentPage=/Point/PointHistory.jsp";
			}
			else if(com.equals("/PointSearchHistory.po")) {	// 검색조건 페이징화시키기. 
				command = new PointSearchListCommand();
				command.execute(request, response);
				viewPage = "MainForm.do?contentPage=/Point/PointHistory.jsp";
			}  
		//admin이 아닐경우에접근시도시 권한없다고 뜨게만듬.
		} else {
				viewPage = "/Point/PointAuthorityCheck.jsp";
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
