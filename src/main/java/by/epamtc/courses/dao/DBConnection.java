package by.epamtc.courses.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private Connection connection;

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("database.properties")
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}

