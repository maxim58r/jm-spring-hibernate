package ru.max.webapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.max.webapp.config.AppConfig;
import ru.max.webapp.models.User;
import ru.max.webapp.service.UserService;
import ru.max.webapp.service.UserServiceImp;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Serov Maxim
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

        userService.create(user1);
        userService.create(user2);
        userService.create(user3);
        userService.create(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}