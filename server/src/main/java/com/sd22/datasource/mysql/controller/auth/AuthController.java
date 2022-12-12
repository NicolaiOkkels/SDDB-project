package com.sd22.datasource.mysql.controller.auth;

import com.sd22.datasource.mysql.dto.AuthDto;
import com.sd22.datasource.mysql.dto.LoginDto;
import com.sd22.datasource.mysql.dto.RegisterDto;
import com.sd22.datasource.mysql.entity.Role;
import com.sd22.datasource.mysql.entity.User;
import com.sd22.datasource.mysql.service.RoleService;
import com.sd22.datasource.mysql.service.UserService;
import com.sd22.datasource.security.jwt.JwtAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private UserService userService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private JwtAuthToken jwtAuthToken;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, RoleService roleService, PasswordEncoder passwordEncoder, JwtAuthToken jwtAuthToken) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtAuthToken = jwtAuthToken;
    }

    @PostMapping("login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtAuthToken.generateToken(authentication);
        return new ResponseEntity<>(new AuthDto(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if(userService.existsByUsername(registerDto.getEmail())){
            return new ResponseEntity<>("Username is already in use", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role role = roleService.findRoleByName("USER").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRoles(userRoles);

        userService.addUser(user);

        return new ResponseEntity<>("User registered success", HttpStatus.OK);
    }
}
