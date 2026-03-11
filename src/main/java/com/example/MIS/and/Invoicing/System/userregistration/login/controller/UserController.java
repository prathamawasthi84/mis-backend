package com.example.MIS.and.Invoicing.System.userregistration.login.controller;

import com.example.MIS.and.Invoicing.System.userregistration.login.dto.UserDTO;
import com.example.MIS.and.Invoicing.System.userregistration.login.entity.UserEntity;
import com.example.MIS.and.Invoicing.System.userregistration.login.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController (UserService userService){
        this.userService=userService;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }
}
