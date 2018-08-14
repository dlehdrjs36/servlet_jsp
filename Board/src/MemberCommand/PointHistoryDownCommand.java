package MemberCommand;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.write.WriteException;
import DAO.PointDao;

public class PointHistoryDownCommand implements MemberCommand {
// 회원 포인트사용이력 다운
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {	
		PointDao dao = new PointDao();
		try {
			dao.excelExport();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
