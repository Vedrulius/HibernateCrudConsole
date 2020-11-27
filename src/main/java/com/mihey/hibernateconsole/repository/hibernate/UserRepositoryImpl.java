package com.mihey.hibernateconsole.repository.hibernate;

import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.repository.UserRepository;
import com.mihey.hibernateconsole.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final Session session = HibernateUtil.getSession();

    @Override
    public List<User> getAll() {
        return session.createQuery("FROM Post", User.class).list();
    }

    @Override
    public User getById(Integer id) {
        return session.get(User.class,id);
    }

    @Override
    public User save(User user) {
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public User update(User user) {
        session.getTransaction().begin();
        session.update(user);
        session.getTransaction().commit();
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        session.getTransaction().begin();
        User user = session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
    }
}
