package com.example.MIS.and.Invoicing.System.userregistration.login.controller;

import com.example.MIS.and.Invoicing.System.userregistration.login.dto.LoginInDTO;
import com.example.MIS.and.Invoicing.System.userregistration.login.dto.UserDTO;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;
import com.example.MIS.and.Invoicing.System.userregistration.login.service.EmailService;
import com.example.MIS.and.Invoicing.System.userregistration.login.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final EmailService emailService;
    private final UserService userService;
    public UserController (UserService userService,EmailService emailService){
        this.userService=userService;
        this.emailService=emailService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDTO){
        try {
            userService.saveUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam String token){
        String result = userService.verifyEmail(token);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginInDTO loginDTO) {
        String token = userService.Login(loginDTO);
        return ResponseEntity.ok(token);
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        System.out.println("Logout hit!");
        String token = authHeader.substring(7); // remove "Bearer "
        String result = userService.logout(token);
        return ResponseEntity.ok(result);
    }
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        String result = userService.forgotPassword(email);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String token, @RequestParam String newPassword) {
        String result = userService.resetPassword(token, newPassword);
        return ResponseEntity.ok(result);
    }
}
