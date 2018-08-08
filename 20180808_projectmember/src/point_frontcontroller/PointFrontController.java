package point_frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.command.PointCommand;
import point.command.PointInsertCommand;
import point.command.PointListCommand;



/**
 * Servlet implementation class PointFrontController
 */
@WebServlet("*.do")
public class PointFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		 
		String viewPage = null;
		PointCommand command = null;
		
		String uri = request.getRequestURI(); // uri : www.itworld.co.kr/news/110310
		String conPath = request.getContextPath(); // conPath ex) uri : www.itworld.co.kr/news/110310 -> contextPath : /news/110310
		String com = uri.substring(conPath.length()); // uri에서 contextpath를 짜름.
		
		if(com.equals("/PointList.do")) {
			command = new PointListCommand();
			command.execute(request, response);
			viewPage = "PointList.jsp";
		} else if(com.equals("/PointInsert.do")) {
			command = new PointInsertCommand();
			command.execute(request, response);
			viewPage = "PointList.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage); // viewPage를 담아서 디스패처에게 일을 위임함.
		dispatcher.forward(request, response);
		
	}

}
