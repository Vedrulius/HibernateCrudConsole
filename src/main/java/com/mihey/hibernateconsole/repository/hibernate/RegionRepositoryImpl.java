package com.mihey.hibernateconsole.repository.hibernate;

import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.repository.RegionRepository;
import com.mihey.hibernateconsole.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RegionRepositoryImpl implements RegionRepository {

    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private Session session;

    @Override
    public List<Region> getAll() {
        session = sessionFactory.openSession();
        List<Region> list = session.createQuery("FROM Post", Region.class).list();
        session.close();
        return list;
    }

    @Override
    public Region getById(Integer id) {
        session = sessionFactory.openSession();
        Region region = session.get(Region.class, id);
        session.close();
        return region;
    }

    @Override
    public Region save(Region region) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(region);
        session.getTransaction().commit();
        session.close();
        return region;
    }

    @Override
    public Region update(Region region) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(region);
        session.getTransaction().commit();
        session.close();
        return region;
    }

    @Override
    public void deleteById(Integer id) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Region region = new Region();
        region.setId(id);
        session.delete(region);
        session.getTransaction().commit();
        session.close();
    }
}
