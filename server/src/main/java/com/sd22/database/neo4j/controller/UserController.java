package com.sd22.database.neo4j.controller;
import com.sd22.database.neo4j.entity.User;
import com.sd22.database.neo4j.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/neo4j/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/users")
    public User createTrip(@RequestParam User user){
        return userService.save(user);
    }

    @DeleteMapping("/delete")
    public void deleteTrip(@RequestParam("email") String email){
        userService.delete(email);
    }
}
