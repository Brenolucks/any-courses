package brenolucks.anycourses.jwt;

import brenolucks.anycourses.service.JwtServiceImpl;
import brenolucks.anycourses.service.UserService.UserDetailsServiceImpl;
import brenolucks.anycourses.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtServiceImpl jwtServiceImpl;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtAuthenticationFilter(JwtServiceImpl jwtServiceImpl, UserDetailsServiceImpl userDetailsService) {
        this.jwtServiceImpl = jwtServiceImpl;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = jwtServiceImpl.extractToken(request);

        if(token != null && jwtServiceImpl.tokenValid(token)) {
            var username = jwtServiceImpl.getUsernameByToken(token);
            var userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(), null, userDetails.getAuthorities()
            );

            usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request, response);
    }


}
