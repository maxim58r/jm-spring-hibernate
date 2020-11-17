package ru.max.webapp.dao;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User findByUsername(String username);

    void updateUser(String username, User updateUser);

    void deleteUser(String username);

    List<User> findAll();

}
