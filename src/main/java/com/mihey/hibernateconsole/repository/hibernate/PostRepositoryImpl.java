package com.mihey.hibernateconsole.repository.hibernate;

import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.util.HibernateUtil;
import com.mihey.hibernateconsole.repository.PostRepository;
import org.hibernate.Session;

import java.util.List;

public class PostRepositoryImpl implements PostRepository {

    private final Session session = HibernateUtil.getSession();

    @Override
    public List<Post> getAll() {
        return session.createQuery("FROM Post", Post.class).list();
    }

    @Override
    public Post getById(Integer id) {
        return session.get(Post.class, id);
    }

    @Override
    public Post save(Post post) {
        session.getTransaction().begin();
        session.save(post);
        session.getTransaction().commit();
        return post;
    }

    @Override
    public Post update(Post post) {
        session.getTransaction().begin();
        session.update(post);
        session.getTransaction().commit();
        return post;
    }

    @Override
    public void deleteById(Integer id) {
        session.getTransaction().begin();
        Post post = new Post();
        post.setId(id);
        session.delete(post);
        session.getTransaction().commit();
    }

    @Override
    public List<Post> getPostsByUserId(Integer id) {
        return null;
    }
}
