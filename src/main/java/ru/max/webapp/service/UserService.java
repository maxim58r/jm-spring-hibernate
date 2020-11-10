package ru.max.webapp.service;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserService {
    void create(User user);

    User readUser(long id);

    void update(long id, User updateUser);

    void delete(long id);

    List<User> listUsers();

//    User getUser(String model, int series);


}

