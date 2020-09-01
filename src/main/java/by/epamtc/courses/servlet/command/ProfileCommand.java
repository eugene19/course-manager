package by.epamtc.courses.servlet.command;

import by.epamtc.courses.dao.DaoException;
import by.epamtc.courses.dao.UserDao;
import by.epamtc.courses.dao.impl.UserDaoImpl;
import by.epamtc.courses.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ProfileCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        String login = (String) session.getAttribute("login");
        UserDao userDao = new UserDaoImpl();

        try {
            User user = userDao.getByLogin(login);
            req.setAttribute("user", user);
            req.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(req, resp);
        } catch (DaoException e) {
            //log
            e.printStackTrace();
        }
    }
}
