package jm.task.core.jdbc;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Winnie", "Pooh", (byte) 5);
//        System.out.println("User с именем – Winnie добавлен в базу данных");
//        userService.saveUser("Vladimir", "Putin", (byte) 70);
//        System.out.println("User с именем – Vladimir добавлен в базу данных");
//        userService.saveUser("Vincent", "Van Gogh", (byte) 37);
//        System.out.println("User с именем – Vincent добавлен в базу данных");
//        userService.saveUser("Michael", "Jackson", (byte) 50);
//        System.out.println("User с именем – Michael добавлен в базу данных");
//        userService.getAllUsers().forEach(System.out::println);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
        SessionFactory sessionFactory = Util.getSessionFactory();
        System.out.println(sessionFactory.isClosed());
        SessionFactory sessionFactory2 = Util.getSessionFactory();
        System.out.println(sessionFactory.isClosed());


    }
}
