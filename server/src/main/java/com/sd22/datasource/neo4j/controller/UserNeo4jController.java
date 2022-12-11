package com.sd22.datasource.neo4j.controller;
import com.sd22.datasource.neo4j.entity.User;
import com.sd22.datasource.neo4j.service.UserNeo4jService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/rest/neo4j/user")
public class UserNeo4jController {

    private final UserNeo4jService userNeo4jService;

    public UserNeo4jController(UserNeo4jService userNeo4jService) {
        this.userNeo4jService = userNeo4jService;
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return userNeo4jService.getAll();
    }

    @GetMapping("/getUserRoles")
    public List<User> getUserRoles(){
        return userNeo4jService.getUserRoles();
    }

    @GetMapping("/")
    public User getReviewById(@RequestParam("id") String id){
        Optional<User> userOpt = userNeo4jService.getUserById(Long.parseLong(id));
        if(userOpt.isPresent()){
            return userOpt.get();
        }
        throw new NoSuchElementException("No user found with given id");
    }

    @PostMapping("/users")
    public User createTrip(@RequestParam User user){
        return userNeo4jService.save(user);
    }

    @DeleteMapping("/delete")
    public String deleteTrip(@RequestParam("id") String id){
        userNeo4jService.delete(Long.parseLong(id));
        return "User deleted successfully";
    }
}
