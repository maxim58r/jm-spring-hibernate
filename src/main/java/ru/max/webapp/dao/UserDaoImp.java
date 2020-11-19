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
        testUser(user);
    }

    private void testUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        User user = findById(id);
        user.setUsername(updateUser.getUsername());
        user.setPassword(updateUser.getPassword());
        user.setRole(updateUser.getRole());
//        user.setFirstName(updateUser.getFirstName());
//        user.setLastName(updateUser.getLastName());
//        user.setEmail(updateUser.getEmail());
        saveUser(user);
    }

    @Override
    public void deleteUser(long id) {
        if (entityManager.contains(findById(id))) {
            User user = findById(id);
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
