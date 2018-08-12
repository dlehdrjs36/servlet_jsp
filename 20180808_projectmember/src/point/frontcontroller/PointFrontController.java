package point.frontcontroller;

import java.io.IOException;

import java.sql.SQLException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import point.command.PointCommand;
import point.command.PointHistoryCommand;
import point.command.PointHistoryDownCommand;
import point.command.PointListCommand;
import point.command.PointSearchListCommand;
import point.command.PointUpdateSaveCommand;
import point.command.PointUpdateUseCommand;
import point.command.PointUserCommand;

@WebServlet("*.do")
public class PointFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;      
    public PointFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
			actionDo(request, response);	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			actionDo(request, response);		
	}	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		// 관리자와 일반유저를 구분하기위한 세션id 받아옴.
		HttpSession session = request.getSession();
		session.setAttribute("sessionID", "admin"); //임의로 세션값 설정한부분. 실제로는 받아오기만하면됨.
		String sessionID = (String) session.getAttribute("sessionID");
		System.out.println(sessionID);
		//
		request.setCharacterEncoding("UTF-8");		 
		String viewPage = null;
		PointCommand command = null;		
		String uri = request.getRequestURI(); // uri : www.itworld.co.kr/news/110310
		String conPath = request.getContextPath(); // conPath ex) uri : www.itworld.co.kr/news/110310 -> contextPath : /news/110310
		String com = uri.substring(conPath.length()); // uri�뿉�꽌 contextpath瑜� 吏쒕쫫.		
	
		// admin만 수행가능한 메뉴.
		if( session.getAttribute("sessionID").equals("admin")) {
			if(com.equals("/Point/PointList.do")) { // 목록화면.
				command = new PointListCommand();
				command.execute(request, response);
				viewPage = "/Point/PointList.jsp";				
			}  	
			else if (com.equals("/Point/PointUpdateSaveView.do")) { // 포인트 적립화면
				viewPage = "/Point/PointUpdateSave.jsp";
			}  
			else if (com.equals("/Point/PointUpdateUseView.do")) { // 포인트 사용 화면
				viewPage = "/Point/PointUpdateUse.jsp";
			}  	
			else if(com.equals("/Point/PointUpdateSave.do")) { // 포인트 적립 작업수행후 목록화면이동.
				command = new PointUpdateSaveCommand();
				command.execute(request, response);
				viewPage = "/Point/PointList.do";
			}  
			else if(com.equals("/Point/PointUpdateUse.do")) { // 포인트 사용 작업수행후 목록화면이동. 
				command = new PointUpdateUseCommand();
				command.execute(request, response);
				viewPage = "/Point/PointList.do";
			}
			else if(com.equals("/Point/PointHistoryDown.do")) { // 포인트사용이력 엑셀로 다운
				command = new PointHistoryDownCommand();
				command.execute(request, response);
				viewPage = "/Point/PointHistory.do";
			}  
			else if ( com.equals("/Point/PointHistory.do")) { // 포인트사용이력화면
				command = new PointHistoryCommand(); 
				command.execute(request, response);
				viewPage = "/Point/PointHistory.jsp";
			}
			else if(com.equals("/Point/PointSearchHistory.do")) {	// 검색조건 페이징화시키기. 
				command = new PointSearchListCommand();
				command.execute(request, response);
				viewPage = "/Point/PointHistory.jsp";
			}  
		} 
		//admin이 아닐경우에접근시도시 권한없다고 뜨게만듬.
		else {
				viewPage = "/Point/PointAuthorityCheck.jsp";
		}
		// 유저 자기자신의 포인트 정보 확인.
		if(com.equals("/Point/PointUser.do")) { 
			command = new PointUserCommand();
			command.execute(request, response);
			viewPage = "/Point/PointUserView.jsp"; 
		}  
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // viewPage瑜� �떞�븘�꽌 �뵒�뒪�뙣泥섏뿉寃� �씪�쓣 �쐞�엫�븿.
		dispatcher.forward(request, response);	
	}
}