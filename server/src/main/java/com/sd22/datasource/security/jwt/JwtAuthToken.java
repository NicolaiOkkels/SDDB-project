package com.sd22.datasource.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtAuthToken {

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${app.jwtSecretKey}")
    private String jwtSecretKey;

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationMs);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecretKey)
                .compact();

        return token;
    }

    public String getUsernameFromJwt(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
            return true;
        }catch (Exception ex){
            throw new AuthenticationCredentialsNotFoundException("Jwt was expired or incorrect");
        }
    }
}
