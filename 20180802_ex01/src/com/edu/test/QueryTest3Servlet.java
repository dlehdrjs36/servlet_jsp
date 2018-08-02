package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/queryTest3") // 서블릿 맵퍼. queryTest3으로 호출하면 여기(내)가 동작. 프로그램에서 맵퍼 연결하는방법 : 어노테이션 연결방법.
public class QueryTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 전달방식이 get이면 doget , post면 dopost, 아무것도 주지않으면 default인 doget이 동작한다.
// 받는거는 req객체로 받고 돌려줄때는 resp객체로 돌려줌. 
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열 테스트</title></head>");
		out.print("<body>");
		out.print("<h1>GET 방식으로 요청되었습니다</h1>");

		String name = req.getParameter("name");
		System.out.println(name);
		// response 객체에 담기는 내용들 (html로 변환되는 부분들) 25~27 부분. 이걸 req가 온곳에 돌려줌.
		out.print("이름 : " + name + "<br/>");
		out.println("</body></html>");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");  // 처리하는곳(여기)에서 req(받은거)를 utf-8로 인코딩함. post로 전달할때 한글 깨짐 방지
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String hobby[] = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String religion = req.getParameter("religion");
		String introduction = req.getParameter("introduction");
		
		
		
		resp.setContentType("text/html;charset=UTF-8"); // 돌려주는 객체(resp)를 utf-8로 인코딩하겠다,그리고 파일의형태는 html이다..
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열 테스트</title></head>");
		out.print("<body>");
		out.print("<h1>POST 방식으로 요청되었습니다</h1>");
		out.print("ID : " + id + "<br/>");
		out.print("패스워드 : " + pwd + "<br/>");
		out.print("이름 : " + name + "<br/>");
		out.print("취미 : ");
		for(String i : hobby ) 
		   out.print( i + " ");	
		out.print("<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("종교 : " + religion + "<br/>");
		out.print("자기소개 : " + introduction + "<br/>");
		out.println("</body></html>");
		out.close();
	}
}
