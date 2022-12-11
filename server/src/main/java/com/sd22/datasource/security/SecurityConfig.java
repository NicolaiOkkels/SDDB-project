/*package com.sd22.datasource.security;

import com.sd22.datasource.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private AuthEntryPointJwt

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.ignoringAntMatchers("/swagger-ui/**", "/api-docs/**"))
                .authorizeRequests(auth -> auth
                        .antMatchers("/swagger-ui/**", "/api-docs/**").permitAll()
                        .mvcMatchers("/api/counties/**", "/api/locations/**",
                                "/api/reviews/**","/api/tags/**", "/api/trips/**",
                                "/api/packages/**").hasAuthority("USER")
                        .mvcMatchers("/api/users/**").hasAuthority("ADMIN")
                        .anyRequest().authenticated())
                .userDetailsService(myUserDetailsService)
                .httpBasic()
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/

