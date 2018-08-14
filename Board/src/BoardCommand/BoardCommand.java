package BoardCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {
	void execute(HttpServletRequest req, HttpServletResponse resp);
}
