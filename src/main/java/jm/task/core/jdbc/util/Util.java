package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String hostName = "localhost";
    private static final String dbName = "mydb";
    private static final String userName = "root";
    private static final String password = "root";

    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
        return getConnection(hostName, dbName, userName, password);
    }

    public static Connection getConnection(String hostName, String dbName,
                                           String userName, String password) throws SQLException,
            ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String URL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
        Connection conn = DriverManager.getConnection(URL, userName,
                password);
        return conn;
    }
}