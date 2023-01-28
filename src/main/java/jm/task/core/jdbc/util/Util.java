package jm.task.core.jdbc.util;

    // реализуйте настройку соеденения с БД


        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;


public class Util {



    public static Connection getConnection() throws SQLException,
            ClassNotFoundException {
        String hostName = "localhost";

        String dbName = "mydb";
        String userName = "root";
        String password = "root";

        return getConnection(hostName, dbName, userName, password);
    }

    public static Connection getConnection(String hostName, String dbName,
                                                String userName, String password) throws SQLException,
            ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}