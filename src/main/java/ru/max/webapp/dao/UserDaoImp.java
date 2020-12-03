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
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setPassword(user.getPassword());
            entityManager.persist(user);
        } else updateUser(user);
    }

    @Override
    public void updateUser(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
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
        return query.getResultList();
    }
}
