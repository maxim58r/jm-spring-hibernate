package ru.max.webapp.dao;

import org.springframework.stereotype.Repository;
import ru.max.webapp.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.find(User.class, username);
    }

    @Override
    public void updateUser(String username, User updateUser) {
        User user = findByUsername(username);
        user.setUsername(updateUser.getUsername());
        user.setPassword(updateUser.getPassword());
//        user.setFirstName(updateUser.getFirstName());
//        user.setLastName(updateUser.getLastName());
//        user.setEmail(updateUser.getEmail());
        saveUser(user);
    }

    @Override
    public void deleteUser(String username) {
        if (entityManager.contains(findByUsername(username))) {
            User user = findByUsername(username);
            entityManager.remove(user);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Query query = entityManager.createQuery("select u from User u");
//        return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
        return query.getResultList();
    }
}
