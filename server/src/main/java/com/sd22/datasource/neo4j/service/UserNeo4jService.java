package com.sd22.datasource.neo4j.service;

import com.sd22.datasource.neo4j.repository.UserNeo4jRepository;
import com.sd22.datasource.neo4j.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserNeo4jService {

    @Autowired
    private UserNeo4jRepository userNeo4jRepository;

    @Transactional("neo4jTransactionManager")
    public List<User> getAll(){
        return userNeo4jRepository.findAll();
    }

    @Transactional("neo4jTransactionManager")
    public Optional<User> getUserById(Long id) {
        return userNeo4jRepository.findById(id);
    }

    @Transactional("neo4jTransactionManager")
    public List<User> getUserRoles(){
        return userNeo4jRepository.getUserRoles();
    }

    @Transactional("neo4jTransactionManager")
    public void delete(Long id){
        userNeo4jRepository.deleteById(id);
    }

    @Transactional("neo4jTransactionManager")
    public User save(User user){
        return userNeo4jRepository.save(user);
    }
}
