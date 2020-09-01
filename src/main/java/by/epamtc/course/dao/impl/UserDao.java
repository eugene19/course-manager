package by.epamtc.course.dao.impl;

import by.epamtc.course.dao.InterfaceDao;
import by.epamtc.course.entity.User;

import java.util.List;

public class UserDao implements InterfaceDao<User> {

    @Override
    public int insert(User ob) {
        return 0;
    }

    @Override
    public void update(User ob) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    public User getByLogin() {
        return null;
    }
}
