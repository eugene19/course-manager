package by.epamtc.course.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    private static final String DATASOURCE_NAME = "jdbc/courses";
    private static DataSource dataSource;

    static {
        try {
//            InitialContext initContext= new InitialContext();
//            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/courses");

            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            dataSource = (DataSource) envCtx.lookup(DATASOURCE_NAME);


//            Context initContext = new InitialContext();
//            Context envContext = (Context) initContext.lookup("java:comp/env/jdbc/courses");
//            dataSource = (DataSource) envContext.lookup(DATASOURCE_NAME);
        } catch (NamingException e) {
            //log
            e.printStackTrace();
        }
    }

    private ConnectionPool() {}

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
