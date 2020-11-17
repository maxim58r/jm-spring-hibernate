package ru.max.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.max.webapp.dao.RoleDao;
import ru.max.webapp.dao.UserDao;
import ru.max.webapp.models.Role;
import ru.max.webapp.models.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional
    @Override
    public void update(String username, User updateUser) {
        userDao.updateUser(username, updateUser);
    }

    @Transactional
    @Override
    public void delete(String username) {
        userDao.deleteUser(username);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}
