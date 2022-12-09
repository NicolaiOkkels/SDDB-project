package com.sd22.database.mysql.controller;

import com.sd22.database.mysql.controller.exceptions.UserNotFoundException;
import com.sd22.database.mysql.entity.User;
import com.sd22.database.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @GetMapping("/update/{id}")
    public User findUserById(@PathVariable int id) {
        try {
            User user = userService.findUserById(id).orElseThrow(UserNotFoundException::new);
            if (user == null) {
                return (User)ResponseEntity.status(HttpStatus.BAD_REQUEST);
            } else {
                return ResponseEntity.ok(user).getBody();
            }
        }catch(DataAccessException e){
            return (User)ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping ("/delete/{id}")
    public User deleteUserById(@PathVariable int id){
        User user = userService.findUserById(id).orElseThrow(UserNotFoundException::new);

        if(user != null){
           userService.deleteUserById(id);
        }
        return user;
    }
}
