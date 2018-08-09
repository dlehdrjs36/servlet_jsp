package point.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import point.dao.PointDao;

public class PointUpdateUseCommand implements PointCommand {
	static public int error_code;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
			
			String id = request.getParameter("id");
			int save = Integer.parseInt(request.getParameter("save"));
			PointDao dao = new PointDao();

			dao.UpdateUsePoint( id, save);
			
			if ( error_code == 1) {
				response.setContentType("text/html; charset=UTF-8");			 
				PrintWriter out;
				try {
					out = response.getWriter();
					out.println("<script>alert('포인트 사용불가. 잔액이 부족해집니다.'); location.href='PointList.do' </script>"); 
					out.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			error_code = 0;
	}

}
