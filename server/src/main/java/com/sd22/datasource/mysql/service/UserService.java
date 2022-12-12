package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.User;
import com.sd22.datasource.mysql.repository.UserRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional("mysqlTransactionManager")
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Transactional("mysqlTransactionManager")
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional("mysqlTransactionManager")
    public User findUserById(int id) {
        return userRepository.findById(id).orElseThrow(()-> new NotFoundException());
    }

    @Transactional("mysqlTransactionManager")
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Transactional("mysqlTransactionManager")
    public boolean existsByUsername(String email) {
        return userRepository.existsByEmail(email);
    }

    @Transactional("mysqlTransactionManager")
    public User updateUser(User user){
        return userRepository.save(user);
    }
}
