package com.mihey.hibernateconsole.repository.hibernate;

import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.repository.UserRepository;
import com.mihey.hibernateconsole.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;

    @Override
    public List<User> getAll() {
        session = sessionFactory.openSession();
        List<User> list=session.createQuery("FROM Post", User.class).list();
        session.close();
        return list;
    }

    @Override
    public User getById(Integer id) {
        session = sessionFactory.openSession();
        User user =session.get(User.class,id);
        session.close();
        return user;
    }

    @Override
    public User save(User user) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        User user = new User();
        user.setId(id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }
}
