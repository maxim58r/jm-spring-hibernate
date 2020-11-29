package ru.max.webapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import ru.max.webapp.models.Role;
import ru.max.webapp.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
    private Role role;

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setPassword(user.getPassword());
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            entityManager.persist(user);
        }
    }

    @Override
    public void updateUser(long id, User updateUser) {
        User user = findById(id);
        user.setUsername(updateUser.getUsername());
        user.setPassword(updateUser.getPassword());
        user.setRoles(updateUser.getRoles());
        entityManager.merge(user);
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
//        return entityManager.createNamedQuery("User.findAll", User.class).getResultList();
        return query.getResultList();
    }
}
