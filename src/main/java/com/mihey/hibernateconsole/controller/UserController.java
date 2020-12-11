package com.mihey.hibernateconsole.controller;

import com.mihey.hibernateconsole.model.User;
import com.mihey.hibernateconsole.repository.UserRepository;
import com.mihey.hibernateconsole.repository.hibernate.UserRepositoryImpl;

import java.util.List;

public class UserController {

    private UserRepository userRepository = new UserRepositoryImpl();

    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    public User editUser(User user) {
        return userRepository.update(user);
    }


    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
