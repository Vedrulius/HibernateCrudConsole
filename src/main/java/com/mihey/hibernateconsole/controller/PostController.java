package com.mihey.hibernateconsole.controller;

import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.repository.PostRepository;
import com.mihey.hibernateconsole.repository.hibernate.PostRepositoryImpl;

import java.util.List;

public class PostController {

    private final PostRepository postRepository = new PostRepositoryImpl();

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPostsById(int id) {
        return postRepository.getById(id);
    }

    public Post editPost(Post post) {
        return postRepository.update(post);
    }

    public void deletePostById(int id) {
        postRepository.deleteById(id);
    }

    public List<Post> showAllPosts() {
        return postRepository.getAll();
    }

    public List<Post> getPostsByUserId(Integer id) {
        return postRepository.getPostsByUserId(id);
    }

}

