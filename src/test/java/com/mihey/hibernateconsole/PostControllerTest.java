package com.mihey.hibernateconsole;

import com.mihey.hibernateconsole.controller.PostController;
import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.repository.PostRepository;
import org.apache.maven.toolchain.model.PersistedToolchains;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.PersistenceException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    Post post = new Post();

    {
        post.setId(1);
        post.setUserId(1);
        post.setContent("Hello JavaTest");
        post.setCreated(new Timestamp(System.currentTimeMillis()));
        post.setUpdated(new Timestamp(System.currentTimeMillis()));
    }

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostController postController = new PostController();

    @Test
    public void getPostByIdTest() {
        Mockito.when(postRepository.getById(anyInt())).thenReturn(post);
        Assert.assertEquals(post, postController.getPostsById(1));
        Assert.assertNotEquals("Hello Java", postController.getPostsById(1)
                .getContent());
    }

    @Test
    public void createPostTest() {
        Mockito.when(postRepository.save(post)).thenReturn(post);
        Assert.assertEquals(post, postController.createPost(post));
        Assert.assertNotEquals("Hello Test", postController.createPost(post).getContent());
    }

    @Test
    public void editPostTest() {
        post.setContent("Hello Mockito");
        Mockito.when(postRepository.update(post)).thenReturn(post);
        Assert.assertEquals(post, postController.editPost(post));
        Assert.assertNotEquals("Hello Java Test", postController.editPost(post).getContent());
    }

    @Test(expected = PersistenceException.class)
    public void deletePostByIdTest() {
        Mockito.doNothing().when(postRepository).deleteById(anyInt());
        postController.deletePostById(1);
        Mockito.doThrow(new PersistenceException()).when(postRepository).deleteById(2);
        postController.deletePostById(2);
    }

    @Test
    public void showAllPostsTest() {
        List<Post> posts = new ArrayList<>();
        posts.add(post);
        Mockito.when(postRepository.getAll()).thenReturn(posts);
        Assert.assertEquals(posts, postController.showAllPosts());
        Assert.assertNotEquals(0, postController.showAllPosts().size());
    }
}
