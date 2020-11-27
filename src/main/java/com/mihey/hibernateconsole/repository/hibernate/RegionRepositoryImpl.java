package com.mihey.hibernateconsole.repository.hibernate;

import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.repository.RegionRepository;
import com.mihey.hibernateconsole.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class RegionRepositoryImpl implements RegionRepository {

    private final Session session = HibernateUtil.getSession();

    @Override
    public List<Region> getAll() {
        return session.createQuery("FROM Post", Region.class).list();
    }

    @Override
    public Region getById(Integer id) {
        return session.get(Region.class, id);
    }

    @Override
    public Region save(Region region) {
        session.getTransaction().begin();
        session.save(region);
        session.getTransaction().commit();
        return region;
    }

    @Override
    public Region update(Region region) {
        session.getTransaction().begin();
        session.update(region);
        session.getTransaction().commit();
        return region;
    }

    @Override
    public void deleteById(Integer id) {
        session.getTransaction().begin();
        Region region = new Region();
        region.setId(id);
        session.delete(region);
        session.getTransaction().commit();
    }
}
