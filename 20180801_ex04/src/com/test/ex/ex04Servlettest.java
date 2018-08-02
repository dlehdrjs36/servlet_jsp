package com.test.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ex04Servlettest
 */
@WebServlet("/ex04test")
public class ex04Servlettest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");  // 처리하는곳(여기)에서 req(받은거)를 utf-8로 인코딩함. post로 전달할때 한글 깨짐 방지
		String id = req.getParameter("작성자");
		String date = req.getParameter("작성일자");
		String name = req.getParameter("제목");	
		String introduction = req.getParameter("introduction");
		
		resp.setContentType("text/html;charset=UTF-8"); // 돌려주는 객체(resp)를 utf-8로 인코딩하겠다,그리고 파일의형태는 html이다..
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>ex04 test</title></head>");
		out.print("<body>");
		out.print("<h1>POST 방식으로 요청되었습니다</h1>");
		out.print("<table border=\"1\" width=\"500\" >");
		out.print("<tr>" );
		out.print("<td>작성자</td>"); 
		out.print("<td>" + id + "</td>");
		out.print("<td>작성일자</td>");
		out.print("<td>"+ date +"</td>");
		out.print("</tr>");
		out.print("<tr>");
	    out.print("<td>제목</td>");
	    out.print("<td colspan=\"3\">" + name +"</td>");
	    out.print("</tr>");
	    out.print("<tr>");
	    out.print("<td colspan=\"4\">" + introduction +"</td>");
	    out.print("</tr>");
	    out.print("</table></body></html>");		
		out.close();
	}

}
