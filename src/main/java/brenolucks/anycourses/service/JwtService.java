package brenolucks.anycourses.service;

import brenolucks.anycourses.model.User;
import jakarta.servlet.http.HttpServletRequest;

import javax.crypto.SecretKey;

public interface JwtService {
    String extractToken(HttpServletRequest httpServletRequest);
    boolean tokenValid(String token);
    SecretKey getSigningKey();
    String generateToken(User user);
    String getUsernameByToken(String token);
}
