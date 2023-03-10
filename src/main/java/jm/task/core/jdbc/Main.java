package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Winnie", "Pooh", (byte) 5);
        System.out.println("User с именем – Winnie добавлен в базу данных");
        userService.saveUser("Vladimir", "Putin", (byte) 70);
        System.out.println("User с именем – Vladimir добавлен в базу данных");
        userService.saveUser("Vincent", "Van Gogh", (byte) 37);
        System.out.println("User с именем – Vincent добавлен в базу данных");
        userService.saveUser("Michael", "Jackson", (byte) 50);
        System.out.println("User с именем – Michael добавлен в базу данных");
        userService.getAllUsers().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
