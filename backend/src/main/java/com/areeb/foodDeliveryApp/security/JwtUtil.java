package com.areeb.foodDeliveryApp.security;


import com.areeb.foodDeliveryApp.auth_users.entites.User;
import io.github.cdimascio.dotenv.Dotenv;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class JwtUtil {
    private Dotenv dotenv = Dotenv.load();

    public SecretKey getSecretKey(){
        String secretString = dotenv.get("SECRET_STRING");
        return Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
    }

    public String generateJwtToken(User user){
        return Jwts.builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*10))
                .signWith(getSecretKey())
                .compact();
    }

    public String verifyTokenAndGetUsername(String token) throws BadCredentialsException{
        Claims claim =  Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        String email = claim.getSubject();
        return email;
    }


}
