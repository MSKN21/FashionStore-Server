package com.example.FashionStore.Service;

import com.example.FashionStore.Model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<?> getUsers();

    public ResponseEntity<?> getUserById(Integer userId);

    public ResponseEntity<?> createUser(User user);

    public ResponseEntity<?> updateUser(User user);

    public ResponseEntity<?> deleteUser(User user);
}
