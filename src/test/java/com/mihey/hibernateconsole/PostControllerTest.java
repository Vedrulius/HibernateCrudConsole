package com.mihey.hibernateconsole;

import com.mihey.hibernateconsole.controller.PostController;
import com.mihey.hibernateconsole.model.Post;
import com.mihey.hibernateconsole.repository.PostRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {

    @Mock
    PostRepository postRepository;

    @InjectMocks
    PostController postController = new PostController();

    @Test
    public void getPostByIdTest() {
        Post post = new Post();
        post.setId(1);
        post.setContent("Hello JavaTest");
        Mockito.when(postRepository.getById(anyInt())).thenReturn(post);
        Assert.assertEquals("Hello JavaTest", postController.getPostsById(1)
                .getContent());
    }
}
