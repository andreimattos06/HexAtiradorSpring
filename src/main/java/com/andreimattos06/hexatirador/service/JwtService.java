package com.andreimattos06.hexatirador.service;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    //Testing purposes only -------------
    byte[] decodedKey = Decoders.BASE64.decode("7UHIR94xUifHKJtNxea2CdzBh/i9vw8+v3O4mheTwz5n4BzcOlK83zJVAUN0pGJxQigaHr2J1q9QVyMQ0VYxpwS/MjJcxi0PcODlhcklH6KQ8+/GF4+hKixO3jZ1DV/mSlvYDaeE/lRhwO0uZSK2tctkbIU11dW/Nv6Q3+mlkLEdArn6uURBOPjww8ubdGKMF/jsiGiXFo6ux4o5Ll2Exwf/QxC71lKQs1S+NTNcVibmqtvu4WV7CbTBk+kM5CFjJDkf+i+5tjt54ZfswZC+5LmDHY7CZdyWUm+xbyN0jiY/TKZhlcJRS/V6/d818gE4ZmYeWZxdIv6JbqUJI/meFw==");
    SecretKey key = Keys.hmacShaKeyFor(decodedKey);
    //Testing purposes only -------------


    public String extractProfileEmail(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }

    public <T>T extractClaim(String token, Function<Claims, T> claimResolver){
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public String generateToken( 
        Map<String, Object> extraClaims, 
        UserDetails userDetails){

            return Jwts.builder()
            .claims(extraClaims)
            .subject(userDetails.getUsername())
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .issuedAt(new Date(System.currentTimeMillis()))
            .signWith(key)
            .compact();

           /* return Jwts.builder()
            .setClaims(extraClaims)
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
            */

    }

    public String generateToken( 
        UserDetails userDetails){
            
            return Jwts.builder()
            .subject(userDetails.getUsername())
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .issuedAt(new Date(System.currentTimeMillis()))
            .signWith(key)
            .compact();

           /* return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
            */

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
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();        
    }


    
}
