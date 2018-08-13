package MemberCommand;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.MemberDAO;
import DTO.MemberBean;

public class MemberJoinCommand implements MemberCommand {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
	        MemberBean bean = new MemberBean();
	        bean.setId(req.getParameter("id"));
	        bean.setPassword(req.getParameter("password"));
	        bean.setName(req.getParameter("name"));
	        bean.setGender(req.getParameter("gender"));
	        bean.setBirthday(req.getParameter("birthday"));
	        bean.setEmail(req.getParameter("email"));
	        bean.setTel1(req.getParameter("tel1"));
	        bean.setTel2(req.getParameter("tel2"));
	        bean.setTel3(req.getParameter("tel3"));
	        bean.setAddr(req.getParameter("addr"));
	        bean.setAddrdetail(req.getParameter("addrdetail"));
	        bean.setAddrnum(req.getParameter("addrnum"));
	        MemberDAO dao = MemberDAO.getInstance();
	        try {
				dao.insertMember(bean);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	}

}
