package by.epamtc.courses.servlet.command;

import by.epamtc.courses.dao.DaoException;
import by.epamtc.courses.dao.UserDao;
import by.epamtc.courses.dao.impl.UserDaoImpl;
import by.epamtc.courses.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        UserDao userDao = new UserDaoImpl();

        try {
            User userLogin = userDao.getByLogin(login);

            if (userLogin != null) {
                String userPassword = userLogin.getPassword();

                if (userPassword.equals(password)) {
                    req.getSession().setAttribute("isAuthorize", "true");
                    req.getSession().setAttribute("user", userLogin);
                    resp.sendRedirect(req.getContextPath() + "/");
                } else {
                    req.setAttribute("error", "wrong password");
                    req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
                }
            } else {
                resp.getWriter().println("No user");
            }
        } catch (DaoException e) {
            //log
            e.printStackTrace();
        }
    }
}
