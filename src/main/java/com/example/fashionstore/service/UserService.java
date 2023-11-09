package com.example.fashionstore.service;

import com.example.fashionstore.model.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public User getUserById(Integer userId);

    public User createUser(User user);

    public User updateUser(User user);

    public String deleteUser(User user);

}
