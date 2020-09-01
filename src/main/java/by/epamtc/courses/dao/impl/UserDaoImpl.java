package by.epamtc.courses.dao.impl;

import by.epamtc.courses.dao.ConnectionPool;
import by.epamtc.courses.dao.DaoException;
import by.epamtc.courses.dao.UserDao;
import by.epamtc.courses.entity.User;
import by.epamtc.courses.entity.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String GET_BY_LOGIN_SQL = "select USER.ID, USER.LOGIN, USER.PASSWORD, USER.NAME, USER.SURNAME, USER_TYPE.TYPE" +
            " from USER INNER JOIN USER_TYPE ON USER.USER_TYPE=USER_TYPE.id where USER.LOGIN = ?;";

    private static final String INSERT_USER_SQL = "INSERT INTO USER (LOGIN, PASSWORD, NAME, SURNAME, USER_TYPE) " +
            "VALUES (?, ?, ?, ?, ?);";

    @Override
    public User getByLogin(String login) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_LOGIN_SQL);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String userLogin = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String surname = resultSet.getString(5);
                String type = resultSet.getString(6);

                User user = new User();
                user.setId(id);
                user.setLogin(userLogin);
                user.setPassword(password);
                user.setName(name);
                user.setSurname(surname);
                user.setType(UserType.valueOf(type));

                return user;
            }

        } catch (SQLException e) {
            //log
            throw new DaoException(e);
        }

        return null;
    }

    @Override
    public List<User> getAll() throws DaoException {
        return null;
    }

    @Override
    public User getById(int id) throws DaoException {
        return null;
    }

    @Override
    public void update(User ob) throws DaoException {

    }

    @Override
    public int insert(User ob) throws DaoException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, ob.getLogin());
            preparedStatement.setString(2, ob.getPassword());
            preparedStatement.setString(3, ob.getName());
            preparedStatement.setString(4, ob.getSurname());
            preparedStatement.setInt(5, ob.getType().getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //log
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {

    }
}
