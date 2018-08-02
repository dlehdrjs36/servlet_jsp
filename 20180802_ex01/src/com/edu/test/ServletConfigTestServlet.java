package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
//		String env =this.getInitParameter("charset");  //환경변수를 잘 못가져오는거같아서 막아둠.
		req.setCharacterEncoding("utf-8");
		out.print("<h3> 이름 :"+req.getParameter("name"));
		out.close();
	}
}