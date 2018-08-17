package FrontController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BoardCommand.BoardCommand;
<<<<<<< HEAD
import BoardCommand.BoardCountCommand;
import BoardCommand.BoardDeleteCommand;
import BoardCommand.BoardDetailCommand;
import BoardCommand.BoardLIstCommand;
import BoardCommand.BoardReplyCommand;
import BoardCommand.BoardReplyFormCommand;
import BoardCommand.BoardSearchCommand;
import BoardCommand.BoardUpdateCommand;
import BoardCommand.BoardWriteCommand;


@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		BoardCommand command = null;
		String uri = request.getRequestURI();
		System.out.println(uri);
		String conPath = request.getContextPath();
		System.out.println(conPath);
		String com = uri.substring(conPath.length());
		System.out.println(com);
		
		if(com.equals("/BoardWriteForm.bo")) {
			viewPage = "MainForm.do?contentPage=/board/view/BoardWriteForm.jsp";
		} else if(com.equals("/BoardWrite.bo")) {
			command = new BoardWriteCommand();
			command.execute(request, response);
			viewPage="BoardList.bo";
		} else if(com.equals("/BoardList.bo")) {
			command = new BoardLIstCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardListForm.jsp";
		} /*else if(com.equals("/BoardDetail.bo")) {
			command = new BoardDetailCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardDetailForm.jsp";
		}*/ else if(com.equals("/BoardDelete.bo")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			int check = Integer.parseInt(request.getAttribute("msg").toString());
			System.out.println("check : "+check);
			if( check ==1) {
			viewPage="BoardList.bo?msg=1";
			} else {
				viewPage="BoardList.bo";
			}
		}
		// 조회수 증가기능
		else if(com.equals("/BoardCount.bo")) {
			command = new BoardCountCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardDetailForm.jsp";
		}
		// 게시판 수정기능
		else if(com.equals("/BoardUpdateForm.bo")) {
			command = new BoardDetailCommand();	// detail command 사용.
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardUpdateForm.jsp";
		}
		// 게시판 수정기능
		else if(com.equals("/BoardUpdate.bo")) {
			command = new BoardUpdateCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardListForm.jsp";
		}
		// 게시판 검색기능
		else if(com.equals("/BoardSearch.bo")) {
			command = new BoardSearchCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardListForm.jsp";
		}  
		// 답글기능
		else if(com.equals("/BoardReplyForm.bo")) {
			command = new BoardReplyFormCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardReplyForm.jsp";
		}
		else if(com.equals("/BoardReply.bo")) {
			command = new BoardReplyCommand();
			command.execute(request, response);
			viewPage="BoardList.bo";
		}  
		
=======
import BoardCommand.BoardDeleteCommand;
import BoardCommand.BoardDetailCommand;
import BoardCommand.BoardLIstCommand;
import BoardCommand.BoardUpdateFormCommand;
import BoardCommand.BoardWriteCommand;


@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BoardController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String viewPage = null;
		BoardCommand command = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		if(com.equals("/BoardWriteForm.bo")) {
			viewPage = "MainForm.do?contentPage=/board/view/BoardWriteForm.jsp";
		} else if(com.equals("/BoardWrite.bo")) {
			command = new BoardWriteCommand();
			command.execute(request, response);
			viewPage="BoardList.bo";
		} else if(com.equals("/BoardList.bo")) {
			command = new BoardLIstCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardListForm.jsp";
		} else if(com.equals("/BoardDetail.bo")) {
			command = new BoardDetailCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardDetailForm.jsp";
		} else if(com.equals("/BoardDelete.bo")) {
			command = new BoardDeleteCommand();
			command.execute(request, response);
			int check = Integer.parseInt(request.getAttribute("msg").toString());
			System.out.println("check : "+check);
			if( check ==1) {
			viewPage="BoardList.bo?msg=1";
			} else {
				viewPage="BoardList.bo";
			}
		} else if(com.equals("/BoardUpdateForm.bo")) {
			command = new BoardUpdateFormCommand();
			command.execute(request, response);
			viewPage="MainForm.do?contentPage=/board/view/BoardUpdateForm.jsp";
		}  
>>>>>>> refs/remotes/origin/master
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
