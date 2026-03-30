package com.example.MIS.and.Invoicing.System.jwt;

import com.example.MIS.and.Invoicing.System.userregistration.login.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;
    public JwtFilter(JwtUtil jwtUtil,CustomUserDetailsService customUserDetailsService){
        this.jwtUtil=jwtUtil;
        this.customUserDetailsService=customUserDetailsService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            filterChain.doFilter(httpServletRequest,httpServletResponse);
            return;
        }
        String extractToken = authHeader.substring(7);
        if(jwtUtil.validateToken(extractToken)){
            String email = jwtUtil.extractEmail(extractToken);
            String role = jwtUtil.extractRole(extractToken);

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(email,null, List.of(new SimpleGrantedAuthority(role)));

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
