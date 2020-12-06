package com.mihey.hibernateconsole.repository.hibernate;

import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.repository.RegionRepository;
import com.mihey.hibernateconsole.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RegionRepositoryImpl implements RegionRepository {

    private Session session;

    @Override
    public List<Region> getAll() {
        session = HibernateUtil.getSession();
        List<Region> list = session.createQuery("FROM Post", Region.class).list();
        session.close();
        return list;
    }

    @Override
    public Region getById(Integer id) {
        session = HibernateUtil.getSession();
        Region region = session.get(Region.class, id);
        session.close();
        return region;
    }

    @Override
    public Region save(Region region) {
        Region region1 = isExists(region);
        if (region1 == null) {
            session = HibernateUtil.getSession();
            session.getTransaction().begin();
            session.save(region);
            session.getTransaction().commit();
            session.close();
        } else {
            return region1;
        }
        return region;
    }

    @Override
    public Region update(Region region) {
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(region);
        session.getTransaction().commit();
        session.close();
        return region;
    }

    @Override
    public void deleteById(Integer id) {
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Region region = new Region();
        region.setId(id);
        session.delete(region);
        session.getTransaction().commit();
        session.close();
    }

    private Region isExists(Region region) {
        session = HibernateUtil.getSession();
        Query query = session.createQuery("from Region where name = :name");
        query.setParameter("name", region.getName().toLowerCase());
        region = (Region) query.uniqueResult();
        session.close();
        return region;
    }
}
