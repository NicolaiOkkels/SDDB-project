package com.sd22.datasource.mongodb.service;


import com.sd22.datasource.mongodb.entity.Trip;
import com.sd22.datasource.mongodb.entity.User;
import com.sd22.datasource.mongodb.repository.UserMongoDBRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserMongoDBService {

    UserMongoDBRepository userMongoDBRepository;

    @Autowired
    public UserMongoDBService(UserMongoDBRepository userMongoDBRepository){
        this.userMongoDBRepository = userMongoDBRepository;
    }

    public User save(User user) {
        return userMongoDBRepository.save(user);
    }

    public Collection<? extends User> findAll() {
        return userMongoDBRepository.findAll();
    }

    public User findUserById(String id) {
        return userMongoDBRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteUserById(String id) {
        userMongoDBRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userMongoDBRepository.save(user);
    }
}

