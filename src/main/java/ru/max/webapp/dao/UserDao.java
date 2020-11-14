package ru.max.webapp.dao;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User findById(long id);

    void updateUser(long id, User updateUser);

    void deleteUser(long id);

    List<User> findAll();

}
