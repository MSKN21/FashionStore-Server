package com.example.FashionStore.Service.Implementation;

import com.example.FashionStore.Model.User;
import com.example.FashionStore.Repository.UserRepository;
import com.example.FashionStore.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> userDetails() {
        List<User>userList=new ArrayList<>();
        Map<String, Object>response=new HashMap<>();
        userList=userRepository.findAll();
        response.put("UserList",userList);
        response.put("Message","User Details Fetched Successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
