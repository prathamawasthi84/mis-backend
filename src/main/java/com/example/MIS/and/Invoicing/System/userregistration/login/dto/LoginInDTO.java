package com.example.MIS.and.Invoicing.System.userregistration.login.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginInDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public LoginInDTO(){

    }
    //Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    //Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
