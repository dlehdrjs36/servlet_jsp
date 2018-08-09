package point_frontcontroller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.command.PointCommand;
import point.command.PointHistoryCommand;
import point.command.PointHistoryDownCommand;
import point.command.PointListCommand;
import point.command.PointSearchListCommand;
import point.command.PointUpdateSaveCommand;
import point.command.PointUpdateUseCommand;



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
		
		request.setCharacterEncoding("UTF-8");
		 
		String viewPage = null;
		PointCommand command = null;
		
		String uri = request.getRequestURI(); // uri : www.itworld.co.kr/news/110310
		System.out.println(uri);
		String conPath = request.getContextPath(); // conPath ex) uri : www.itworld.co.kr/news/110310 -> contextPath : /news/110310
		System.out.println(conPath);
		String com = uri.substring(conPath.length()); // uri�뿉�꽌 contextpath瑜� 吏쒕쫫.
		System.out.println(com);
		
		if (com.equals("/Point/PointUpdateSaveView.do")) {
			viewPage = "/Point/PointUpdateSave.jsp";
		}  else	if (com.equals("/Point/PointUpdateUseView.do")) {
			viewPage = "/Point/PointUpdateUse.jsp";
		}  else if(com.equals("/Point/PointList.do")) {
			command = new PointListCommand();
			command.execute(request, response);
			viewPage = "/Point/PointList.jsp";
		}  else if(com.equals("/Point/PointHistory.do")) {
			command = new PointHistoryCommand();
			command.execute(request, response);
			viewPage = "/Point/PointHistory.jsp";
		}  else if(com.equals("/Point/PointUpdateSave.do")) {
			command = new PointUpdateSaveCommand();
			command.execute(request, response);
			viewPage = "/Point/PointList.do";
		}  else if(com.equals("/Point/PointUpdateUse.do")) {
			command = new PointUpdateUseCommand();
			command.execute(request, response);
			viewPage = "/Point/PointList.do";
		}  else if(com.equals("/Point/PointHistoryDown.do")) {
			command = new PointHistoryDownCommand();
			command.execute(request, response);
			viewPage = "/Point/PointHistory.do";
		}  else if(com.equals("/Point/PointSearchHistory.do")) {
			command = new PointSearchListCommand();
			command.execute(request, response);
			viewPage = "/Point/PointHistory.jsp";
		}  
		
		//테스트용
		else if ( com.equals("/Point/Page.do")) {
			command = new PointHistoryCommand();
			command.execute(request, response);
			viewPage = "/Point/Page.jsp";
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // viewPage瑜� �떞�븘�꽌 �뵒�뒪�뙣泥섏뿉寃� �씪�쓣 �쐞�엫�븿.
		dispatcher.forward(request, response);
		
	}

}
