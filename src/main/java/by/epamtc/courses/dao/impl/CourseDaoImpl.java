package by.epamtc.courses.dao.impl;

import by.epamtc.courses.dao.ConnectionPool;
import by.epamtc.courses.dao.CourseDao;
import by.epamtc.courses.dao.DaoException;
import by.epamtc.courses.entity.Course;
import by.epamtc.courses.entity.CourseStatus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private static final String SELECT_ALL_COURSES_SQL = "select id, topic, description, " +
            "status from COURSE;";

    @Override
    public int insert(Course ob) throws DaoException {
        return 0;
    }

    @Override
    public void update(Course ob) throws DaoException {

    }

    @Override
    public void delete(int id) throws DaoException {

    }

    @Override
    public Course getById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Course> getAll() throws DaoException {
        List<Course> courses = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_COURSES_SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String topic = resultSet.getString(2);
                String description = resultSet.getString(3);

                Course course = new Course();
                course.setId(id);
                course.setTopic(topic);
                course.setDescription(description);
                course.setStatus(CourseStatus.NOT_STARTED);

                courses.add(course);
            }
        } catch (SQLException e) {
            //log
            throw new DaoException(e);
        }

        return courses;
    }
}
