package com.example.MIS.and.Invoicing.System.userregistration.login.controller;

import com.example.MIS.and.Invoicing.System.userregistration.login.dto.UserDTO;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;
import com.example.MIS.and.Invoicing.System.userregistration.login.service.EmailService;
import com.example.MIS.and.Invoicing.System.userregistration.login.service.UserService;
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
        userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
    @GetMapping("/verify")
    public ResponseEntity<String> verifyEmail(@RequestParam String token){
        String result = userService.verifyEmail(token);
        return ResponseEntity.ok(result);
    }
}
