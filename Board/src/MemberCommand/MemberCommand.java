package MemberCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberCommand {
	void execute(HttpServletRequest req, HttpServletResponse resp);
}
