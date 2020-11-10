package ru.max.webapp.service;

import ru.max.webapp.dao.UserDao;
import ru.max.webapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void create(User user) {
        userDao.saveUser(user);
    }

    @Transactional
    @Override
    public User readUser(int id) {
        return userDao.getUser(id);
    }

    @Transactional
    @Override
    public void update() {
        userDao.updateUser();
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.deleteUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }


}
