package com.example.fashionstore.controller;

import com.example.fashionstore.exceptions.UnhandledException;
import com.example.fashionstore.model.User;
import com.example.fashionstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUsers(){
        Map<String, Object> response=new HashMap<>();
        try {
            List<User> userList = userService.getUsers();
            response.put("UserList",userList);
            response.put("Message","Users Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Integer userId){
        Map<String, Object> response=new HashMap<>();
        try {
            User user = userService.getUserById(userId);
            response.put("User",user);
            response.put("Message","User Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody User user){
        Map<String, Object> response=new HashMap<>();
        try {
            User newUser = userService.createUser(user);
            response.put("NewUser",newUser);
            response.put("Message","Created User Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Map<String, Object> response=new HashMap<>();
        try {
            User updatedUser=userService.updateUser(user);
            response.put("UpdatedUser",updatedUser);
            response.put("Message","Updated User Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestBody User user){
        Map<String, Object> response=new HashMap<>();
        try {
            String message=userService.deleteUser(user);
            response.put("Message",message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (UnhandledException e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
