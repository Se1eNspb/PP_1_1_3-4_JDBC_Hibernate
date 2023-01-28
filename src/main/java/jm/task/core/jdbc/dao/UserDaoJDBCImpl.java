package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final String drop = "DROP TABLE IF EXISTS users;";
    private static final String create = "CREATE TABLE IF NOT EXISTS users(" +
            "id INT PRIMARY KEY AUTO_INCREMENT, " +
            "name VARCHAR(45), " +
            "lastName VARCHAR(45), " +
            "age INT );";
    private static final String save = "INSERT INTO users(name, lastName, age) VALUES('";
    private static final String remove = "DELETE FROM users WHERE id =";
    private static final String getAll = "SELECT * FROM users;";
    private static final String clean = "TRUNCATE TABLE users;";


    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        statementExecute(create);
    }

    public void dropUsersTable() {
        statementExecute(drop);

    }

    public void saveUser(String name, String lastName, byte age) {
        statementExecute(save + name + "', '" + lastName + "', " + age + ");");

    }

    public void removeUserById(long id) {
        statementExecute(remove + id + ";");
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(getAll);
            while (res.next()) {
                User user = new User();
                user.setId(res.getLong("id"));
                user.setName(res.getString("name"));
                user.setLastName(res.getString("lastName"));
                user.setAge(res.getByte("age"));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        statementExecute(clean);
    }

    private void statementExecute(String command) {
        try (Connection connection = Util.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(command);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
