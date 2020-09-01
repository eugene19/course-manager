package by.epamtc.courses.servlet.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/");
    }
}
