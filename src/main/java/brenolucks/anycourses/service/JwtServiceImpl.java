package brenolucks.anycourses.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expiration;

    @Override
    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey())
                .compact();
    }

    @Override
    public String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }

        return null;
    }

    @Override
    public boolean tokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (ExpiredJwtException ex) {
            throw new RuntimeException("Token expired: " + ex.getMessage(), ex);
        } catch (UnsupportedJwtException ex) {
            throw new RuntimeException("Token not supported: " + ex.getMessage(), ex);
        } catch (MalformedJwtException ex) {
            throw new RuntimeException("Token incorret: " + ex.getMessage(), ex);
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Token null or empty: " + ex.getMessage(), ex);
        }
    }

    @Override
    public String getUsernameByToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    @Override
    public SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }


}
