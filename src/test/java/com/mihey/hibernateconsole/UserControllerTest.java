package com.mihey.hibernateconsole;

import com.mihey.hibernateconsole.controller.UserController;
import com.mihey.hibernateconsole.model.Region;
import com.mihey.hibernateconsole.model.Role;
import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    User user = new User();

    {
        user.setId(1);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setRegion(new Region("US"));
        user.setRole(Role.USER);
    }

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController = new UserController();


    @Test
    public void getUserByIdTest() {

        Mockito.when(userRepository.getById(anyInt())).thenReturn(user);
        Assert.assertEquals("John", userController.getUserById(1).getFirstName());
        Assert.assertNotEquals("Jon", userController.getUserById(1).getFirstName());
    }

    @Test
    public void saveUserTest() {
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Assert.assertEquals(user, userController.saveUser(user));
        Assert.assertNotEquals("Jon", userController.saveUser(user).getFirstName());
    }

    @Test
    public void editUserTest() {
        user.setFirstName("Jane");
        Mockito.when(userRepository.update(user)).thenReturn(user);
        Assert.assertEquals(user, userController.editUser(user));
        Assert.assertNotEquals("John", userController.editUser(user).getFirstName());
    }

    @Test
    public void deleteUserByIdTest() {

    }

    @Test
    public void getAllUsersTest() {
        List<User> users = new ArrayList<>();
        users.add(user);
        Mockito.when(userRepository.getAll()).thenReturn(users);
        Assert.assertEquals(users, userController.getAllUsers());
        Assert.assertNotEquals(0, userController.getAllUsers().size());
    }

}
