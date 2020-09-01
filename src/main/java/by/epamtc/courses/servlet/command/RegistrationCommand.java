package by.epamtc.courses.servlet.command;

import by.epamtc.courses.dao.DaoException;
import by.epamtc.courses.dao.UserDao;
import by.epamtc.courses.dao.impl.UserDaoImpl;
import by.epamtc.courses.entity.User;
import by.epamtc.courses.entity.UserType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String type = req.getParameter("type");

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setType(UserType.getById(Integer.parseInt(type)));

        UserDao userDao = new UserDaoImpl();
        try {
            userDao.insert(user);
        } catch (DaoException e) {
            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("WEB-INF/jsp/registration.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/");
    }
}
