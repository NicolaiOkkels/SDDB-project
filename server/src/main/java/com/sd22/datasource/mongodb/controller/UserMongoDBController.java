package com.sd22.datasource.mongodb.controller;
import com.sd22.datasource.mongodb.entity.User;
import com.sd22.datasource.mongodb.service.UserMongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mongo/users")
public class UserMongoDBController {

    @Autowired
    UserMongoDBService userMongoDBService;

    @Autowired
    public UserMongoDBController(UserMongoDBService userMongoDBService){
        this.userMongoDBService = userMongoDBService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<>();
            users.addAll(userMongoDBService.findAll());

            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        try {
            User userSaved = userMongoDBService.save(user);
            return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        Optional<User> userData = Optional.ofNullable(userMongoDBService.findUserById(id));

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setReviews(user.getReviews());
            _user.setEmail(user.getEmail());
            _user.setPassword(user.getPassword());
            _user.setId(user.getId());
            _user.setRoles(user.getRoles());
            return new ResponseEntity<>(userMongoDBService.updateUser(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable String id) {
        try {
            User user = userMongoDBService.findUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUserById(@PathVariable("id") String id) {
        try {
            userMongoDBService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}