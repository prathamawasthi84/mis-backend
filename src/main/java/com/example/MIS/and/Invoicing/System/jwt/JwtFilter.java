package com.example.MIS.and.Invoicing.System.jwt;

import com.example.MIS.and.Invoicing.System.userregistration.login.SessionStatus;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserSession;
import com.example.MIS.and.Invoicing.System.userregistration.login.repository.UserSessionRepository;
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
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserSessionRepository userSessionRepository;
    public JwtFilter(JwtUtil jwtUtil,CustomUserDetailsService customUserDetailsService,UserSessionRepository userSessionRepository){
        this.jwtUtil=jwtUtil;
        this.customUserDetailsService=customUserDetailsService;
        this.userSessionRepository=userSessionRepository;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String token = authHeader.substring(7).trim(); // .trim() handles any accidental whitespace
        if (jwtUtil.validateToken(token)) {
            // check session is ACTIVE in DB
            Optional<UserSession> session = userSessionRepository.findByToken(token);

            if (session.isEmpty() || session.get().getSessionStatus()!= SessionStatus.ACTIVE) {
                filterChain.doFilter(httpServletRequest,httpServletResponse);
                return;  // reject request
            }

            String email = jwtUtil.extractEmail(token);
            String role = jwtUtil.extractRole(token);

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                            email, null, List.of(new SimpleGrantedAuthority(role)));

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
