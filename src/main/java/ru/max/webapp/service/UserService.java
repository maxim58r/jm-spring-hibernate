package ru.max.webapp.service;

import ru.max.webapp.models.User;

import java.util.List;

public interface UserService {
    void create(User user);

    User readUser(int id);

    void update();

    void delete(User user);

    List<User> listUsers();

//    User getUser(String model, int series);


}

