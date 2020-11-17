package ru.max.webapp.service;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    void update(String username, User updateUser);

    void delete(String username);

    List<User> findAll();

}

