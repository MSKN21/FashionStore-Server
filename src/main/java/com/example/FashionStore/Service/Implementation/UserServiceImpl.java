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
    public ResponseEntity<?> getUsers() {
        Map<String, Object>response=new HashMap<>();
        try{
            List<User>userList=new ArrayList<>();
            userList=userRepository.findAll();
            response.put("UserList",userList);
            response.put("Message","User Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> getUserById(Integer userId) {
        Map<String, Object>response=new HashMap<>();
        try{
            User user = userRepository.findById(userId).get();
            if(user == null) throw new NullPointerException("User Not Found");
            response.put("User",user);
            response.put("Message","User Details Fetched Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> createUser(User user) {
        Map<String, Object>response=new HashMap<>();
        try {
            User newUser=userRepository.save(user);
            response.put("NewUser",newUser);
            response.put("Message","Created User Successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> updateUser(User user) {
        User newUser;
        Map<String, Object>response=new HashMap<>();
        try{
            newUser = userRepository.findById(user.getUserId()).get();
            if(newUser == null)
                throw new NullPointerException("User Not Found");
            newUser.setUserEmail(user.getUserEmail());
            newUser.setUserName(user.getUserName());
            newUser.setUserPassword(user.getUserPassword());
            newUser.setUserPic(user.getUserPic());
            newUser.setUserPhone(user.getUserPhone());
            newUser.setUserAddress(user.getUserAddress());
            User updatedUser=userRepository.save(newUser);

            response.put("UpdatedUser",updatedUser);
            response.put("Message","Updated User Successfully");
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteUser(User user) {
        Map<String, Object>response=new HashMap<>();
        try{
            userRepository.deleteById(user.getUserId());
            response.put("Message","Deleted User Successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            response.put("Message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
