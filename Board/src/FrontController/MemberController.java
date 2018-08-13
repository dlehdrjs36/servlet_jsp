package FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import MemberCommand.MemberChangeInfoCommand;
import MemberCommand.MemberCommand;
import MemberCommand.MemberInfoCommand;
import MemberCommand.MemberJoinCommand;
import MemberCommand.MemberLeaveCommand;
import MemberCommand.MemberLoginCommand;
import MemberCommand.MemberLogoutCommand;
import MemberCommand.PointHistoryCommand;
import MemberCommand.PointHistoryDownCommand;
import MemberCommand.PointListCommand;
import MemberCommand.PointSearchListCommand;
import MemberCommand.PointUpdateSaveCommand;
import MemberCommand.PointUpdateUseCommand;
import MemberCommand.PointUserCommand;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//20180813
		HttpSession session = request.getSession();
		String sessionID = (String) session.getAttribute("sessionID");
		System.out.println(sessionID);
		//20180813
		
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		MemberCommand command = null;
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);
		
		/*회원 관련 */
		if(com.equals("/MemberJoinForm.do")) {
			viewPage = "MainForm.do?contentPage=/member/view/MemberJoinForm.jsp";
		} else if(com.equals("/MemberLoginForm.do")) {
			viewPage = "MainForm.do?contentPage=/member/view/MemberLoginForm.jsp";
		} else if(com.equals("/MemberJoinProc.do")) {
			viewPage = "/member/proc/MemberJoinProc.jsp";
		} else if(com.equals("/MainForm.do")) {
			viewPage = "/MainForm.jsp";
		} else if(com.equals("/MemberChangeInfoForm.do")) {
			viewPage = "/MainForm.do?contentPage=/member/view/MemberChangeInfoForm.jsp";
		} else if(com.equals("/MemberCheckPassWordForm.do")) {
			viewPage = "/MainForm.do?contentPage=member/view/MemberCheckPassWordForm.jsp";
		} else if(com.equals("/MemberInfoForm.do")) {
			command = new MemberInfoCommand();
			command.execute(request, response);
			viewPage = "/MainForm.do?contentPage=/member/view/MemberInfoForm.jsp";
		} else if(com.equals("/MemberJoin.do")) {
			command = new MemberJoinCommand();
			command.execute(request, response);
			viewPage="/MainForm.do?contentPage=/member/proc/MemberJoinProc.jsp";
		} else if(com.equals("/MemberLogin.do")) {
			command = new MemberLoginCommand();
			command.execute(request, response);
			viewPage = request.getAttribute("msg").toString();
		} else if(com.equals("/MemberChangeInfo.do")) {
			command = new MemberChangeInfoCommand();
			command.execute(request, response);
			viewPage = request.getAttribute("msg").toString();
		} else if(com.equals("/MemberLogout.do")) {
			command = new MemberLogoutCommand();
			command.execute(request, response);
			viewPage = "/MainForm.do?contentPage=/member/view/MemberLoginForm.jsp";
		} else if(com.equals("/MemberLeave.do")) {
			command = new MemberLeaveCommand();
			command.execute(request, response);
			int check=(int) request.getAttribute("check");
			System.out.println(check);
			if( check == 1 ) {
			//20180813	HttpSession session = request.getSession();
				session = request.getSession();
		        session.invalidate(); 
				viewPage = "/MemberLoginForm.do?msg=1";
			} else if ( check == 0   ) {
				viewPage = "/MemberCheckPassWordForm.do?msg=1";
			}
		}
		// 유저 자기자신의 포인트 정보 확인.
		else if(com.equals("/PointUser.do")) { 
			command = new PointUserCommand();
			command.execute(request, response);
			viewPage = "MainForm.do?contentPage=/Point/PointUserView.jsp"; 
		}
		// admin만 수행가능한 메뉴.
		else if( session.getAttribute("sessionID").equals("admin2")) {
			if(com.equals("/PointList.do")) { // 목록화면.
				command = new PointListCommand();
				command.execute(request, response);
				viewPage = "MainForm.do?contentPage=/Point/PointList.jsp";				
			}  	
			else if (com.equals("/PointUpdateSaveView.do")) { // 포인트 적립화면
				viewPage = "MainForm.do?contentPage=/Point/PointUpdateSave.jsp";
			}  
			else if (com.equals("/PointUpdateUseView.do")) { // 포인트 사용 화면
				viewPage = "MainForm.do?contentPage=/Point/PointUpdateUse.jsp";
			}  	
			else if(com.equals("/PointUpdateSave.do")) { // 포인트 적립 작업수행후 목록화면이동.
				command = new PointUpdateSaveCommand();
				command.execute(request, response);
				viewPage = "/PointList.do";
			}  
			else if(com.equals("/PointUpdateUse.do")) { // 포인트 사용 작업수행후 목록화면이동. 
				command = new PointUpdateUseCommand();
				command.execute(request, response);
				viewPage = "/PointList.do";
			}
			else if(com.equals("/PointHistoryDown.do")) { // 포인트사용이력 엑셀로 다운
				command = new PointHistoryDownCommand();
				command.execute(request, response);
				viewPage = "/PointHistory.do";
			}  
			else if ( com.equals("/PointHistory.do")) { // 포인트사용이력화면
				command = new PointHistoryCommand(); 
				command.execute(request, response);
				viewPage = "MainForm.do?contentPage=/Point/PointHistory.jsp";
			}
			else if(com.equals("/PointSearchHistory.do")) {	// 검색조건 페이징화시키기. 
				command = new PointSearchListCommand();
				command.execute(request, response);
				viewPage = "MainForm.do?contentPage=/Point/PointHistory.jsp";
			}  
		} 
		//admin이 아닐경우에접근시도시 권한없다고 뜨게만듬.
		else {
				viewPage = "/Point/PointAuthorityCheck.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
