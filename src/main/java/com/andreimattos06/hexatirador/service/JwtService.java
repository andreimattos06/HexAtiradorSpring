package com.andreimattos06.hexatirador.service;

import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    //Testing purposes only -------------
    byte[] decodedKey = Decoders.BASE64.decode("afe87ecfcbf3a8db14f0ed4fb93d5af79fb9e7ac21650f7c3ef1b337b3e7be63");
    SecretKey key = Keys.hmacShaKeyFor(decodedKey);
    //Testing purposes only -------------


    public String extractProfileEmail(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public String generateToken( //DEPRECATED -- NEED TO UPDATE
        Map<String, Object> extraClaims, 
        UserDetails userDetails){

            return Jwts.builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

    }

    public String generateToken( //DEPRECATED -- NEED TO UPDATE 
        UserDetails userDetails){

            return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = extractProfileEmail(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().decryptWith(key).build().parseEncryptedClaims(token).getPayload();
        
    }


    
}
