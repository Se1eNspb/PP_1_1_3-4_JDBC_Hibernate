package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static final String create = "CREATE TABLE IF NOT EXISTS users(" +
            "id INT PRIMARY KEY AUTO_INCREMENT, " +
            "name VARCHAR(45), " +
            "lastName VARCHAR(45), " +
            "age INT );";
    private static final String drop = "DROP TABLE IF EXISTS users;";
    private static final String getAll = "SELECT * FROM users";
    private static final String clean = "TRUNCATE TABLE users;";

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.createSQLQuery(create).addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.createSQLQuery(drop).addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList;
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            userList = session.createSQLQuery(getAll).addEntity(User.class).getResultList();
            session.getTransaction().commit();
            session.close();
        }
        return userList;
    }

    @Override
    public void cleanUsersTable() {
        try (Session session = Util.getSession()) {
            session.beginTransaction();
            session.createSQLQuery(clean).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
    }
}
