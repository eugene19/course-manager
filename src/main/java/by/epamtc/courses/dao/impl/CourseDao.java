package by.epamtc.courses.dao.impl;

import by.epamtc.courses.dao.InterfaceDao;
import by.epamtc.courses.entity.Course;

import java.util.List;

public class CourseDao implements InterfaceDao<Course> {

    @Override
    public int insert(Course ob) {
        return 0;
    }

    @Override
    public void update(Course ob) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Course getById(int id) {
        return null;
    }

    @Override
    public List<Course> getAll() {
        return null;
    }
}
