package by.epamtc.course.dao;

import java.util.List;

public interface InterfaceDao<T> {

    int insert(T ob);

    void update(T ob);

    void delete(int id);

    T getById(int id);

    List<T> getAll();
}
