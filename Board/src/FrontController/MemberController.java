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
		HttpSession session = request.getSession();
		MemberCommand command = null;
		
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
			
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
				session = request.getSession();
		        session.invalidate(); 
				viewPage = "/MemberLoginForm.do?msg=1";
			} 
			else if ( check == 0   ) {
				viewPage = "/MemberCheckPassWordForm.do?msg=1";
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
}
