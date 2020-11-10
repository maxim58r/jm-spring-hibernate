package ru.max.webapp.dao;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User getUser(long id);

//    void updateUser();

    void updateUser(long id, User updateUser);

    void deleteUser(long id);

    List<User> listUsers();

//    void saveUser(User user);

//    User getUser(String model, int series);
}
