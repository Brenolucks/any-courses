package brenolucks.anycourses.service;

import jakarta.servlet.http.HttpServletRequest;

import javax.crypto.SecretKey;

public interface JwtService {
    String extractToken(HttpServletRequest httpServletRequest);
    boolean tokenValid(String token);
    SecretKey getSigningKey();
    String generateToken(String username);
    String getUsernameByToken(String token);
}
