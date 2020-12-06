package com.mihey.hibernateconsole.repository.hibernate;

import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.util.HibernateUtil;
import com.mihey.hibernateconsole.repository.PostRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    private Session session;

    @Override
    public List<Post> getAll() {
        session = HibernateUtil.getSession();
        List<Post> posts = session.createQuery("FROM Post", Post.class).list();
        session.close();
        return posts;
    }

    @Override
    public Post getById(Integer id) {
        session = HibernateUtil.getSession();
        Post post = session.get(Post.class, id);
        session.close();
        return post;
    }

    @Override
    public Post save(Post post) {
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(post);
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public Post update(Post post) {
        post.setUpdated(new Timestamp(System.currentTimeMillis()));
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(post);
        session.getTransaction().commit();
        session.close();
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        session = HibernateUtil.getSession();
        session.getTransaction().begin();
        Post post = new Post();
        post.setId(id);
        session.delete(post);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        session = HibernateUtil.getSession();
        Query query = session.createQuery("FROM Post Where user_id = :id");
        query.setParameter("id", userId);
        List<Post> posts = query.list();
        session.close();
        return posts;
    }
}
