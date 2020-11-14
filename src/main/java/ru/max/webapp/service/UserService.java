package ru.max.webapp.service;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findById(long id);

    void update(long id, User updateUser);

    void delete(long id);

    List<User> findAll();

}

