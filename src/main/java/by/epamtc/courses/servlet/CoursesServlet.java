package by.epamtc.courses.servlet;

import by.epamtc.courses.dao.CourseDao;
import by.epamtc.courses.dao.DaoException;
import by.epamtc.courses.dao.impl.CourseDaoImpl;
import by.epamtc.courses.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CoursesServlet extends HttpServlet {
    private static final long serialVersionUID = 2918474281628168624L;

    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Course> courses = courseDao.getAll();
            req.setAttribute("courseList", courses);
            req.getRequestDispatcher("WEB-INF/jsp/courseList.jsp").forward(req, resp);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
