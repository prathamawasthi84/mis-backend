package com.example.MIS.and.Invoicing.System.userregistration.login.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {
    @NotBlank
    private String full_name;
    @NotBlank
    private String email;
    @NotBlank
    @Size(min=10)
    private String password;
    private String role;

    public UserDTO(){}
    //Getters
    public String getFull_name() {
        return full_name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    //Setters
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
}