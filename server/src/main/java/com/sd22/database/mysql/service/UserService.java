package com.sd22.database.mysql.service;

import com.sd22.database.mysql.entity.User;
import com.sd22.database.mysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUserById(int id) {
        return userRepository.findById(id);
    }

    //TODO: missing logic to delete all contrains first etc. reviews
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
