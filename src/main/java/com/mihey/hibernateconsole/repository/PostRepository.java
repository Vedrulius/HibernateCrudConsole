package com.mihey.hibernateconsole.repository;

import com.mihey.hibernateconsole.model.Post;

import java.util.List;

public interface PostRepository extends GenericRepository<Post, Integer> {
    List<Post> getPostsByUserId(Integer id);
}
