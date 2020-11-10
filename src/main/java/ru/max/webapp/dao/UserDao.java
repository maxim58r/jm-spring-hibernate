package ru.max.webapp.dao;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User getUser(int id);

    void updateUser();

    void deleteUser(User user);

    List<User> listUsers();

//    void saveUser(User user);

//    User getUser(String model, int series);
}
