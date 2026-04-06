package com.example.MIS.and.Invoicing.System.userregistration.login.config;

import com.example.MIS.and.Invoicing.System.jwt.JwtFilter;
import com.example.MIS.and.Invoicing.System.userregistration.login.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final CustomUserDetailsService userDetailsService;
    private final JwtFilter jwtFilter;
    public SecurityConfig(CustomUserDetailsService userDetailsService,JwtFilter jwtFilter){
        this.userDetailsService=userDetailsService;
        this.jwtFilter=jwtFilter;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
       http
               .csrf(csrf -> csrf.disable())
               .userDetailsService(userDetailsService)
               .httpBasic(Customizer.withDefaults())
               .authorizeHttpRequests(auth->auth
                       .requestMatchers("/user/register","/user/verify","/user/login","/admin/add-user").permitAll()
                       .requestMatchers(("/admin/**")).hasAuthority("ADMIN")
                       .requestMatchers("/error").permitAll()
                       .anyRequest().authenticated())
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
       return http.build();
    }
}
