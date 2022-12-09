package com.sd22.database.neo4j.service;

import com.sd22.database.neo4j.repository.UserRepository;
import com.sd22.database.neo4j.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void delete(String email){
        userRepository.deleteById(email);
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
