package ru.max.webapp.service;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findById(long id);

    void deleteUser(long id);

    List<User> findAll();

}

