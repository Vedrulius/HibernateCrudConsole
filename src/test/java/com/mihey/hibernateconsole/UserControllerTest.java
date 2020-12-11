package com.mihey.hibernateconsole;

import com.mihey.hibernateconsole.controller.UserController;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.repository.UserRepository;
import com.mihey.hibernateconsole.repository.hibernate.UserRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController = new UserController();

    @Test
    public void getUserByIdTest() {
        User user = new User();
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setRegion(new Region("USA"));
        Mockito.when(userRepository.getById(anyInt())).thenReturn(user);
        Assert.assertEquals("John", userController.getUserById(1).getFirstName());
    }
}
