package com.sd22.datasource.mysql.service;

import com.sd22.datasource.mysql.entity.Role;
import com.sd22.datasource.mysql.entity.Tag;
import com.sd22.datasource.mysql.repository.RoleRepository;
import com.sd22.datasource.mysql.repository.TagRepository;
import com.sd22.datasource.mysql.service.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Transactional("mysqlTransactionManager")
    public Set<Role> getRoles() {
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    @Transactional("mysqlTransactionManager")
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Transactional("mysqlTransactionManager")
    public Role findRoleById(int id) {
        return roleRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional("mysqlTransactionManager")
    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findByName(name);
    }


    @Transactional("mysqlTransactionManager")
    public void deleteRoleById(int id) {
        roleRepository.deleteById(id);
    }

    @Transactional("mysqlTransactionManager")
    public Role updateRole(Role role){
        return roleRepository.save(role);
    }
}
