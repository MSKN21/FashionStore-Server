package com.example.fashionstore.service.implementation;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.User;
import com.example.fashionstore.repository.UserRepository;
import com.example.fashionstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        try{
            List<User>userList=new ArrayList<>();
            userList=userRepository.findAll();
            return userList;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public User getUserById(Integer userId) {
        try{
            User user = userRepository.findById(userId).get();
            return user;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public User createUser(User user) {
        try {
            User newUser=userRepository.save(user);
            return newUser;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public User updateUser(User user) {
        User newUser;
        try{
            newUser = userRepository.findById(user.getUserId()).get();
            newUser.setUserEmail(user.getUserEmail());
            newUser.setUserName(user.getUserName());
            newUser.setUserPassword(user.getUserPassword());
            newUser.setUserPic(user.getUserPic());
            newUser.setUserPhone(user.getUserPhone());
            newUser.setUserAddress(user.getUserAddress());
            User updatedUser=userRepository.save(newUser);
            return updatedUser;
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }

    @Override
    public String deleteUser(User user) {
        try{
            userRepository.deleteById(user.getUserId());
            return "Deleted User Successfully";
        }
        catch (Exception exception){
            throw new UnhandledException(exception.getMessage(),exception);
        }
    }
}
