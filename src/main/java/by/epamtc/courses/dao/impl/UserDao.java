package by.epamtc.courses.dao.impl;

import by.epamtc.courses.dao.InterfaceDao;
import by.epamtc.courses.entity.User;

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
