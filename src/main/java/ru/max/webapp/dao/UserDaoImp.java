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
        entityManager.merge(user);
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        User user = getUser(id);
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setEmail(updateUser.getEmail());
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        if (entityManager.contains(getUser(id))) {
            User user = getUser(id);
            entityManager.remove(user);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Query query = entityManager.createQuery("from User");
//        TypedQuery<User> query =
//                entityManager.createNamedQuery("User.findAll", User.class);
        return query.getResultList();
    }
}
