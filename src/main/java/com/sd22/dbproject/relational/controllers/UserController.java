package com.sd22.dbproject.relational.controllers;

import com.sd22.dbproject.relational.controllers.exceptions.UserNotFoundException;
import com.sd22.dbproject.relational.entities.User;
import com.sd22.dbproject.relational.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

/*    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public User findUserById(@RequestParam int id) {
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
    }*/

    @GetMapping("/users/{id}")
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
    
    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public User deleteUserById(@RequestParam int id){
        User user = userService.findUserById(id).orElseThrow(UserNotFoundException::new);

        if(user != null){
           userService.deleteUserById(id);
        }
        return user;
    }
}
